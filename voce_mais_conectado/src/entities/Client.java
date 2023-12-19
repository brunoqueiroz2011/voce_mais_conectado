package entities;

import interfaces.Authenticable;

public class Client extends User implements Authenticable {

    String email;
    Boolean isLogin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean login) {
        isLogin = login;
    }

    @Override
    public Boolean authentic(String login, String password) {
        return getLogin().equals(login) && getPassword().equals(password);
    }
}
