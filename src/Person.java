public abstract class Person {
    String name;
    int accountNumber;

    Person(String name, int accountNumber){
        this.name = name;
        this.accountNumber = accountNumber;
    }
    public abstract void showDetails();
}