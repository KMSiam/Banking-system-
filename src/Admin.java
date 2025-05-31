import java.util.List;

public class Admin extends Person{
    Admin(){
        super("admin", 9999);
    }

    public boolean login(String name, int accountNumber) {
        return this.name.equals(name) && this.accountNumber == accountNumber;
    }

    public void viewIndividualUser(User user){
        System.out.println("----User Details----");
        user.showDetails();
        System.out.println("Password: " + user.password);
        System.out.println("--------------------");
    }

    public void viewAllUsers(List<User> users){
        System.out.println("----Users List----");
        int count = 1;
        for(User user : users){
            System.out.println(count++ + ".Name: " + user.name + ", Account Number: " + user.accountNumber);
        }
        System.out.println("--------------------");
    }

    @Override
    public void showDetails() {
    }

}