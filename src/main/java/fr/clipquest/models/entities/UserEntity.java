package fr.clipquest.models.entities;

import fr.clipquest.utils.annotations.PrimaryKey;
import fr.clipquest.utils.annotations.Table;

import java.time.LocalDateTime;

@Table(name = "user")
public class UserEntity extends Entity {

    @PrimaryKey
    private int id;

    private String username;

    private String email;

    private String password;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String email, String password, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
