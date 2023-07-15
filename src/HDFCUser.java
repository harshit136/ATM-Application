import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements AtmInterface{

    //variables for HDFCUser
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    public HDFCUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest=6.5;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
        return "Updated Balance : "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if (Objects.equals(enteredPassword, password)){
            if (amount>balance){
                return "Insufficient Money";
            }
            else {
                balance=balance-amount;
                return "Updated Balance = " + balance;

            }
        }
        else {
            return "Wrong Password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return balance + (balance*years*rateOfInterest)/100;
    }
}
