package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.Collections;

public class Hall {

    private int hallID;
    private int studentCapacity;
    private Weighting weighting;
    private ArrayList<Application> allApplication = new ArrayList<Application>();

    public Hall(int hallNum, int studentNum, Weighting weight) {
        this.hallID = hallNum;
        this.studentCapacity = studentNum;
        this.weighting = weight;
    }

    public void addApplication(Application a) {
        allApplication.add(a);
        Collections.sort(allApplication);
    }

    public ArrayList<Application> getAllApplication() {
        return this.allApplication;
    }

    public int getHallID() {
        return hallID;
    }

    public int getCapacity() {
        return studentCapacity;
    }

    public Weighting getWeighting() {
        return weighting;
    }

    public void setCapacity(int newCapacity) {
        studentCapacity = newCapacity;
    }

    public void setWeighting(Weighting newWeighting) {
        weighting = newWeighting;
    }

    public String toString() {
        return "Hall " + hallID;
    }

    public String getHallRow() {
        return hallID + "\t" + studentCapacity;
    }
}
