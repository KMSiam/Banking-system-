import java.util.Scanner;

public class Main extends Methods{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("----Main Menu----");
            System.out.println("1. Sign Up");
            System.out.println("2. Login as User");
            System.out.println("3. Login as Admin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> userSignup();
                case 2 -> userLogin();
                case 3 -> adminLogin();
                case 4 -> {
                    System.out.println("Thank you for using the system.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}