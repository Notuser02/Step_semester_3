public class Locker {
    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            System.out.println("success");
        } else {
            System.out.println("rejected, code is still \"" + this.combination + "\"");
        }
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.print("changeCode(\"1234\", \"5678\") -> ");
        l.changeCode("1234", "5678");
        System.out.print("changeCode(\"0000\", \"9999\") -> ");
        l.changeCode("0000", "9999");
    }
}