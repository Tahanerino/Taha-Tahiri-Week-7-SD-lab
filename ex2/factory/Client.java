public class Client {
    public static void main(String[] args) {
        int choice = Integer.parseInt(args[0]);
        Object p = ProgramFactory.createProgram(choice);

        if (p != null) {
            if (p instanceof Program1) {
                ((Program1) p).go();
            } else if (p instanceof Program2) {
                ((Program2) p).go();
            } else if (p instanceof Program3) {
                ((Program3) p).go();
            }
        }
    }
}