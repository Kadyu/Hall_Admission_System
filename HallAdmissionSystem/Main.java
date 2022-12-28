package HallAdmissionSystem;

import java.io.IOException;

import HallAdmissionSystem.exceptions.AuthenticationFailException;
import HallAdmissionSystem.exceptions.InvalidFileException;
import HallAdmissionSystem.exceptions.ResourceNotFoundException;

public class Main {

    public static void main(String[] args) {
    	
    	CommandLineInterface.start();
        AuthenticationSystem authenticationSystem;

        try {
            while (true) {
                authenticationSystem = AuthenticationSystem.getInstance();
                Account account = authenticationSystem.login();
                account.accessSystem();
                if (!CommandLineInterface.getInp("Login as another user? (y/n)").equals("y")) {
                	CommandLineInterface.close();
                    break;
                }
            }

        } catch (IOException | InvalidFileException | AuthenticationFailException | ResourceNotFoundException e) {
        	CommandLineInterface.close();
            CommandLineInterface.printHC("ERROR!", e.getMessage());
        }
    }
}