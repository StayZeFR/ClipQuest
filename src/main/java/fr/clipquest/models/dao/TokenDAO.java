package fr.clipquest.models.dao;

import fr.clipquest.models.entities.TokenEntity;
import fr.clipquest.tools.MACAddressTool;

import java.util.ArrayList;
import java.util.List;

public class TokenDAO extends DAO<TokenEntity> {

    public void cleanTokens(int userId, String computer) {
        List<Object> parameters = new ArrayList<>();
        parameters.add(userId);
        parameters.add(computer);
        this.callProcedure("clean_tokens", parameters);
    }

    public boolean checkToken(int userId, String token) {
        List<Object> parameters = new ArrayList<>();
        parameters.add(userId);
        parameters.add(MACAddressTool.get());
        parameters.add(token);
        return (boolean) this.callFunction("check_token", parameters);
    }

}
