import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    static List<User> users = new ArrayList<>();
    static int userIdCounter = 100001;
    static Scanner sc = new Scanner(System.in);
    static Admin admin = new Admin();

    public static void userSignup(){
        sc.nextLine();
        System.out.println("----User Signup----");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your password: ");
        String pass = sc.nextLine();
        System.out.print("Re-enter password: ");
        String repass = sc.nextLine();

        if(!pass.equals(repass)){
            System.out.println("Passwords do not match. Signup failed.");
            return;
        }
        User newUser = new User(name, pass, userIdCounter++);
        users.add(newUser);
        System.out.println("Signup successful. Your ID is: " + newUser.accountNumber);
    }

    public static void userLogin(){
        System.out.println("----User Login----");
        System.out.print("Enter your Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your password: ");
        String pass = sc.nextLine();

        for(User user : users){
            if((user.accountNumber == accNo) && user.checkPassword(pass)){
                System.out.println("Login successful. Welcome " + user.name);
                userMenu(user);
                return;
            }
        }
        System.out.println("Invalid credentials. Login failed.");
    }

    public static void userMenu(User user){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("----User Menu----");
            user.showDetails();
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    user.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = sc.nextDouble();
                    user.withdraw(amount);
                }
                case 3 -> {
                    System.out.println("Exiting User Menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void adminLogin(){
        System.out.println("----Admin Login----");
        System.out.print("Enter admin User Name: ");
        String name = sc.nextLine();
        System.out.print("Enter admin Password: ");
        int pass = sc.nextInt();

        if(admin.login(name, pass)){
            System.out.println("Admin login successful.");
            adminMenu();
        } else {
            System.out.println("Invalid admin info. Login failed.");
        }
    }

    public static void adminMenu(){
        while(true){
            System.out.println("----Admin Menu----");
            System.out.println("1. View Individual User");
            System.out.println("2. View All Users");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1 -> {
                    System.out.print("Enter Account Number of the user: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    User foundUser = null;
                    for(User user : users){
                        if(user.accountNumber == accNo){
                            foundUser = user;
                            break;
                        }
                    }
                    if(foundUser != null){
                        admin.viewIndividualUser(foundUser);
                    } else {
                        System.out.println("User not found.");
                    }
                }
                case 2 -> admin.viewAllUsers(users);
                case 3 -> {
                    System.out.println("Exiting Admin Menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}