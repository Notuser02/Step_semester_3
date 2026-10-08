public class AttendanceSheet {
    private String[] presentStudents;
    private int maxSize;
    private int count;

    public AttendanceSheet(int maxSize) {
        this.maxSize = maxSize;
        this.presentStudents = new String[maxSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (this.count >= this.maxSize) {
            return;
        }
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return;
            }
        }
        this.presentStudents[this.count] = name;
        this.count++;
    }

    public int getPresentCount() {
        return this.count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}