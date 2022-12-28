package HallAdmissionSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import HallAdmissionSystem.exceptions.InvalidFileException;
import HallAdmissionSystem.exceptions.ResourceNotFoundException;

public class Database {
    private static Database instance = null;
    private HashMap<String, Account> accounts = new HashMap<>();
    private HashMap<Integer, Hall> halls = new HashMap<>();

    private String accountsFilepath = "database/accounts.csv";
    private String hallsFilepath = "database/halls.csv";

    private Database() throws IOException, InvalidFileException {
        loadAccounts();
        loadHalls();
    }

    public static Database getInstance() throws IOException, InvalidFileException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Account getAccount(String username) throws ResourceNotFoundException {
        Account foundAccount = accounts.get(username);
        if (foundAccount == null) {
            throw new ResourceNotFoundException("Account with username [" + username + "] not found!");
        }
        return foundAccount;
    }

    public ArrayList<Hall> getAllHalls() {
        return new ArrayList<Hall>(halls.values());
    }

    private void loadAccounts() throws IOException, InvalidFileException {
        try (BufferedReader bufferedReader = getBufferedReader(accountsFilepath)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(","));
                if (row.size() != 6 && row.size() != 3) {
                    throw new InvalidFileException("Invalid format in accounts.csv");
                }
                if (row.get(0).equals("Student")) {
                    accounts.put(row.get(1),
                            new Student(Integer.parseInt(row.get(3)), row.get(1), row.get(2), strToBool(row.get(4)),
                                    Integer.parseInt(row.get(5))));
                } else if (row.get(0).equals("Admin")) {
                    accounts.put(row.get(1), new Admin(row.get(1), row.get(2)));
                } else {
                    throw new InvalidFileException("No such account type");
                }
            }
        }
    }
    
    public Hall getHall(Integer hallID) throws ResourceNotFoundException {
        Hall foundHall = halls.get(hallID);
        if (foundHall == null) {
            throw new ResourceNotFoundException("Hall with name [" + hallID + "] not found!");
        }
        return foundHall;
    }

    private void loadHalls() throws IOException, InvalidFileException {
        try (BufferedReader bufferedReader = getBufferedReader(hallsFilepath)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(","));
                if (row.size() != 6) {
                    throw new InvalidFileException("Invalid format in halls.csv");
                }

                halls.put(Integer.parseInt(row.get(0)),
                        new Hall(Integer.parseInt(row.get(0)), Integer.parseInt(row.get(1)),
                                new Weighting(Integer.parseInt(row.get(2)), Integer.parseInt(row.get(3)),
                                        Integer.parseInt(row.get(4)), Integer.parseInt(row.get(5)))));

            }
        }
    }

    private BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        return new BufferedReader(fileReader);
    }

    private boolean strToBool(String boolString) {
        if (boolString.equals("TRUE")) {
            return true;
        } else {
            return false;
        }
    }
}
