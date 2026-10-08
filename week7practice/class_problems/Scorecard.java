public class Scorecard {
    private boolean[] results;
    private int totalQuestions;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (this.answersRecorded < this.totalQuestions) {
            this.results[this.answersRecorded] = isCorrect;
            this.answersRecorded++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.answersRecorded; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}