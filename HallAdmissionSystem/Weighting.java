package HallAdmissionSystem;

public class Weighting {

    private int academicWeighting;
    private int locationWeighting;
    private int inHallActivitiesWeighting;
    private int examWeighting;

    public Weighting(int academicW, int examW, int inHallActivitiesW, int locationW) {
        this.academicWeighting = academicW;
        this.examWeighting = examW;
        this.inHallActivitiesWeighting = inHallActivitiesW;
        this.locationWeighting = locationW;
    }

    public int[] getWeights() {
        return new int[] { academicWeighting, examWeighting, inHallActivitiesWeighting, locationWeighting };
    }

}
