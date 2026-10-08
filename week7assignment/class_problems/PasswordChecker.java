public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = this.password.length();

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("Strength of \"abcd\": " + pc.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("Strength of \"abcdefghij\": " + pc2.getStrength());
        PasswordChecker pc3 = new PasswordChecker("abc123456");
        System.out.println("Strength of \"abc123456\": " + pc3.getStrength());
    }
}