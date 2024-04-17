package fr.clipquest.tools;

import org.mindrot.jbcrypt.BCrypt;

public class HashTool {

    public static String hash(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
