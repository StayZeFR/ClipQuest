package fr.clipquest.tools;

import fr.clipquest.models.dao.TokenDAO;
import fr.clipquest.models.entities.TokenEntity;

import java.util.UUID;

public class TokenTool {

    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }

    public static void save(int user, String token) {
        TokenDAO dao = new TokenDAO();
        TokenEntity entity = new TokenEntity();
        entity.setIdUser(user);
        entity.setComputer(MACAddressTool.get());
        entity.setToken(token);
        dao.create(entity);
    }

}
