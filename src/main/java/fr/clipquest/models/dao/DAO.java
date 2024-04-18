package fr.clipquest.models.dao;

import fr.clipquest.models.Database;
import fr.clipquest.models.entities.Entity;
import fr.clipquest.utils.annotations.PrimaryKey;
import fr.clipquest.utils.annotations.Table;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public abstract class DAO<T extends Entity> {

    private final Connection connection;
    private final Class<T> clazz;
    private final String table;

    protected DAO() {
        this.connection = Database.getConnection();
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.table = this.clazz.getAnnotation(Table.class).name();
    }

    public List<T> getAll() {
        String query = "SELECT * FROM " + this.table;
        ResultSet resultSet = this.executeQuery(query);
        return this.toEntities(resultSet);
    }

    public T get(Object id) {
        String query = "SELECT * FROM " + this.table + " WHERE";
        Field[] fields = this.clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                query += " " + field.getName() + " = ?";
                break;
            }
        }
        List<Object> parameters = new ArrayList<>();
        parameters.add(id);
        ResultSet resultSet = this.executeQuery(query, parameters);
        return this.toEntities(resultSet).getFirst();
    }

    public List<T> get(String column, Object value) {
        String query = "SELECT * FROM " + this.table + " WHERE " + column + " = ?";
        List<Object> parameters = new ArrayList<>();
        parameters.add(value);
        ResultSet resultSet = this.executeQuery(query, parameters);
        return this.toEntities(resultSet);
    }

    public void create(T entity) {
        StringBuilder query = new StringBuilder("INSERT INTO " + this.table + " (");
        Field[] fields = this.clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(PrimaryKey.class)) {
                query.append(field.getName()).append(", ");
            }
        }
        query = new StringBuilder(query.substring(0, query.length() - 2) + ") VALUES (");
        for (Field field : fields) {
            if (!field.isAnnotationPresent(PrimaryKey.class)) {
                query.append("?, ");
            }
        }
        query = new StringBuilder(query.substring(0, query.length() - 2) + ")");
        List<Object> parameters = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!field.isAnnotationPresent(PrimaryKey.class)) {
                    parameters.add(field.get(entity));
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        this.executeUpdate(query.toString(), parameters);
    }

    public void update(T entity) {
    }

    public void delete(T entity) {
    }

    public Object getLastInsertId() {
        String query = "SELECT LAST_INSERT_ID()";
        ResultSet resultSet = this.executeQuery(query);
        Object id = null;
        try {
            while (resultSet.next()) {
                id = resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private ResultSet executeQuery(String query) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    private ResultSet executeQuery(String query, List<Object> parameters) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    private void executeUpdate(String query) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeUpdate(String query, List<Object> parameters) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(query);
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<T> toEntities(ResultSet resultSet) {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = this.toEntity(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    private T toEntity(ResultSet resultSet) {
        T entity = this.createInstance(this.clazz);
        try {
            Field[] fields = this.clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(entity, resultSet.getObject(field.getName()));
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private T createInstance(Class<? extends Entity> clazz) {
        T instance = null;
        try {
            Constructor<? extends Entity> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = (T) constructor.newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
