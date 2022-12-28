package HallAdmissionSystem;

import java.io.IOException;
import java.util.Date;

import HallAdmissionSystem.exceptions.InvalidFileException;

public class Application implements Comparable<Application> {

    private ApplicationState state;
    private Score score;
    private Date applicationDate;
    private Hall selectedHall;
    private Student student;

    public Application(Student student, int hallID, Score scr) throws IOException, InvalidFileException {

        HallAdmissionSystem hallSystem = HallAdmissionSystem.getInstance();
        this.student = student;
        this.score = scr;
        this.applicationDate = new Date();
        this.selectedHall = hallSystem.getHall(hallID);
        this.state = new ApplicationInProgress();
    }

    @Override
    public String toString() {
        return "* Application information * " + "\n" +
                "Date: " + this.applicationDate + "\n" +
                "Student ID: " + getSid() + "\n" +
                "Academic Year: " + student.getYear() + "\n" +
                "Student type: " + getIsLocalString() + "\n" +
                "Hall preference: " + selectedHall.getHallID() + "\n" +
                "Application total score is: " + getTotalScore() + "\n" +
                "Application state: " + state.notifyStudent();

    }

    @Override
    public int compareTo(Application application) {
        if (this.getTotalScore() > application.getTotalScore()) {
            return -1;
        } else if (this.getTotalScore() == application.getTotalScore()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object application) {
        if (application == this)
            return true;
        if (application == null || application.getClass() != this.getClass()) {
            return false;
        }

        Application comparedApplication = (Application) application;
        if (comparedApplication.getSid() == getSid()
                && (comparedApplication.getAppDate().compareTo(this.applicationDate) == 0)) {
            return true;
        } else {
            return false;
        }

    }

    public int getTotalScore() {
        ScoreCalculator calculator = new ScoreCalculator(this);
        return calculator.calculateScore();
    }

    public Hall getHall() {
        return this.selectedHall;
    }

    public Score getScore() {
        return this.score;
    }

    public int getSid() {
        return student.getSid();
    }

    public Date getAppDate() {
        return this.applicationDate;
    }

    public void setState(ApplicationState newState) {
        this.state = newState;
    }

    public ApplicationState getState() {
        return this.state;
    }

    public boolean getIsLocalStudent() {
        return student.getIsLocalStudent();
    }

    public String getApplicationStateRow() {
        return student.getUsername() + "\t" + selectedHall + "\t\tTotal Score: " + getTotalScore() + "\t("
                + state.getStateString() + ")";
    }

    public Boolean isProcessed() {
        return this.state.isProcessed();
    }

    private String getIsLocalString() {
        if (this.getIsLocalStudent()) {
            return "Local student";
        } else {
            return "Non-local student";
        }
    }
}
