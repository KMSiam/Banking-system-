public class User extends Person{
    final String password;
    public double balance;

    User(String name, String password, int accountNumber){
        super(name, accountNumber);
        this.password = password;
        this.balance = 0.0;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Money added successfully.");
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance.");
        }else{
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    @Override
    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
