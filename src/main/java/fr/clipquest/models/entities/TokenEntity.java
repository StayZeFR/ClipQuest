package fr.clipquest.models.entities;

import fr.clipquest.utils.annotations.PrimaryKey;
import fr.clipquest.utils.annotations.Table;

import java.time.LocalDateTime;

@Table(name = "token")
public class TokenEntity extends Entity {

    @PrimaryKey
    private int id;
    private int id_user;
    private String computer;
    private String token;
    private LocalDateTime created_at;

    public TokenEntity() {
    }

    public TokenEntity(int id, int id_user, String computer, String token, LocalDateTime created_at) {
        this.id = id;
        this.id_user = id_user;
        this.computer = computer;
        this.token = token;
        this.created_at = created_at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return this.id_user;
    }

    public void setIdUser(int id_user) {
        this.id_user = id_user;
    }

    public String getComputer() {
        return this.computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

}
