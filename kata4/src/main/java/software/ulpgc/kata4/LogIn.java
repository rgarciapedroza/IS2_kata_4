package software.ulpgc.kata4;

import java.util.HashMap;

public class LogIn {
    private final HashMap<String, String> logInData;

    public LogIn() {
        this.logInData = SqliteAccountLoader.logInData;
    }


    public String checkEmail(String email, String password){
        if (logInData.containsKey(email)) {
            String storedPassword = logInData.get(email);
            if (storedPassword.equals(password)) {
                return "Log in succesful";
            } else {
                return "Wrong password";
            }
        } else {
            return "Email nor found";
        }



    }
}
