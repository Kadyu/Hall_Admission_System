package HallAdmissionSystem;

import java.io.IOException;

import HallAdmissionSystem.exceptions.AuthenticationFailException;
import HallAdmissionSystem.exceptions.InvalidFileException;
import HallAdmissionSystem.exceptions.ResourceNotFoundException;

public class AuthenticationSystem {
    private Database database;
    private static AuthenticationSystem instance = null;

    private AuthenticationSystem() throws IOException, InvalidFileException {
        database = Database.getInstance();
    }

    public static AuthenticationSystem getInstance() throws IOException, InvalidFileException {
        if (instance == null) {
            instance = new AuthenticationSystem();
        }
        return instance;
    }

    public Account login() throws AuthenticationFailException, ResourceNotFoundException {
        CommandLineInterface.printHC("Authentication System", "Please login to continue");
        String username = CommandLineInterface.getInp("Enter username");
        String password = CommandLineInterface.getInp("Enter password");
        Account account = database.getAccount(username);
        if (!account.validatePassword(password)) {
            throw new AuthenticationFailException("Password not correct for user [" + account.getUsername() + "]!");
        }
        return account;
    }
}
