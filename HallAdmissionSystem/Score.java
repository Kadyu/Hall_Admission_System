package HallAdmissionSystem;

public class Score {

    private int academic;
    private int inHallActivities;
    private int examScore;
    private int locationScore;

    public Score(double academic, int inHallActivities, int exam, String examType, String location) {

        int exScore = this.getExamScore(exam, examType);
        int locScore = this.getLocationScore(location);
        int academicScore = this.getAcademicScore(academic);
        this.academic = academicScore;
        this.inHallActivities = Math.min(inHallActivities, 10);
        this.examScore = exScore;
        this.locationScore = locScore;
    }

    private int getLocationScore(String loc) {
        if (loc.equals("Kowloon")) {
            return 5;
        } else if (loc.equals("Hong Kong Island")) {
            return 8;
        } else if (loc.equals("New Territories")) {
            return 12;
        } else {
            return 18;
        }
    }

    private int getExamScore(int exam, String examType) {
        if (examType.equals("DSE")) {
            return exam;
        } else if (examType.equals("IELTS")) {
            return Math.max((exam - 4) * 5, 0);
        } else {
            return 0;
        }
    }

    private int getAcademicScore(double gpa) {
        if (gpa < 2.5) {
            return 5;
        } else if (gpa < 3.3) {
            return 10;
        } else if (gpa < 3.7) {
            return 15;
        } else {
            return 20;
        }
    }

    public int[] getScores() {
        return new int[] { academic, examScore, inHallActivities, locationScore };
    }

}
