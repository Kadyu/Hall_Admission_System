package HallAdmissionSystem;

import java.io.IOException;

import HallAdmissionSystem.exceptions.InvalidFileException;

public abstract class Account {
    protected String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean validatePassword(String inputPassword) {
        return inputPassword.equals(this.password);
    }

    public abstract void accessSystem() throws IOException, InvalidFileException;

}
