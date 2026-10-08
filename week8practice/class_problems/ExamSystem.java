import java.util.*;

interface Question {
    String getType();
    double calculateScore();
}

class MCQ implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public MCQ(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() { return "MCQ"; }

    public double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer.trim()) ? points : 0;
    }
}

class TrueFalse implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public TrueFalse(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() { return "TF"; }

    public double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer.trim()) ? points : 0;
    }
}

class Essay implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public Essay(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() { return "ESSAY"; }

    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String lowerStudent = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            if (lowerStudent.contains(kw.trim().toLowerCase())) {
                matches++;
            }
        }
        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

class ExamGrader {
    public void processQuestions(List<Question> questions) {
        double total = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}

public class ExamSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        
        List<Question> questions = new ArrayList<>();
        ExamGrader grader = new ExamGrader();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = parseQuoted(line);
            
            String type = parts[0];
            String questionText = parts[1];
            String correctAnswer = parts[2];
            String studentAnswer = parts[3];
            int points = Integer.parseInt(parts[4]);
            
            Question q = null;
            switch (type) {
                case "MCQ": q = new MCQ(questionText, correctAnswer, studentAnswer, points); break;
                case "TF": q = new TrueFalse(questionText, correctAnswer, studentAnswer, points); break;
                case "ESSAY": q = new Essay(questionText, correctAnswer, studentAnswer, points); break;
            }
            if (q != null) questions.add(q);
        }
        grader.processQuestions(questions);
    }

    private static String[] parseQuoted(String line) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (current.length() > 0) {
                    parts.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) parts.add(current.toString());
        return parts.toArray(new String[0]);
    }
}