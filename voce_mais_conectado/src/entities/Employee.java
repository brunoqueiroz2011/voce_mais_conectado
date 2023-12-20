package entities;

import interfaces.Authenticable;
import utils.PrintScreen;

public class Employee extends User implements Authenticable {
    @Override
    public Boolean authentic(String login, String password) {
        return getLogin().equals(login) && getPassword().equals(password);
    }
}
