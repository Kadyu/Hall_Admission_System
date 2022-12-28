package HallAdmissionSystem;

public class ScoreCalculator {

    private Application application;

    public ScoreCalculator(Application ap) {
        this.application = ap;
    }

    public int calculateScore() {

        Score applicationScore = application.getScore();
        Hall hall = application.getHall();
        Weighting weight = hall.getWeighting();

        int scores[] = applicationScore.getScores();
        int hallWeights[] = weight.getWeights();
        int total = 0;

        for (int i = 0; i < hallWeights.length; i++) {
            total += scores[i] * hallWeights[i];
        }
        return total;
    }

}
