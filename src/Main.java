import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name, password, balance to create an account :");

        //create user
        String name= sc.next();
        String password= sc.next();
        double balance= sc.nextInt();
        SBIUser user=new SBIUser(name,balance,password);
        HDFCUser user1=new HDFCUser(name,balance,password);

        //add Money
        String message= user.addMoney(00);
        String message1=user1.addMoney(00);
        System.out.println(message+message1);

        //withdraw Money
        System.out.print("Enter amount you want to withdraw : " );
        int amount= sc.nextInt();
        System.out.print("Enter Password : ");
        String userpassword= sc.next();
        System.out.println(user.withdrawMoney(amount,userpassword));



        //rate of Interest
        System.out.println("MONEY after 10 years with SBI Bank : "+ user.calculateInterest(10));
        System.out.println("MONEY after 10 years with HDFC Bank : "+ user1.calculateInterest(10));
    }
}