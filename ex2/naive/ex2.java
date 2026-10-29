import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        System.out.println("1, 2 or 3: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            Program1 p = new Program1();
            p.go();
        } else if (choice == 2) {
            Program2 p = new Program2();
            p.go();
        } else if (choice == 3) {
            Program3 p = new Program3();
            p.go();
        }
    }
}