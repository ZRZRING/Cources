import java.util.Date;

class Account {
    private int id;
    private double balance;
    private Date dateCreated;
    
    public Account() {
        this.id = ++Global.ID_count;
        this.dateCreated = new Date();
    }

    public int Getid() {
        return id;
    }

    public Date GetDate() {
        return dateCreated;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Remaining balance: " + balance);
    }
}