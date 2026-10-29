public class ProgramFactory {
    public static Program createProgram(int choice) {
        if (choice == 1) {
            return new Program1();
        } else if (choice == 2) {
            return new Program2();
        } else if (choice == 3) {
            return new Program3();
        }

        return null;
    }
}