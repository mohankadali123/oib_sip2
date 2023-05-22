import java.util.Scanner;

class Atm
{
    String name;
    String username;
    String password;
    String accountno;
    double balance=500000;
    int transactions=0;
    String transactionHistory="";

    public void register()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        name = scan.nextLine();
        System.out.println("Enter Your Username: ");
        username = scan.nextLine();
        System.out.println("Enter Your Password: ");
        password = scan.nextLine();
        System.out.println("Enter Your Account Number: ");
        name = scan.nextLine();
        System.out.println("\nRegistratipon completed Sucessfully: ");

    }
    
    public boolean login()
    {
        boolean isLogin =false;
        Scanner scan = new Scanner(System.in);
        while(!isLogin)
        {
            System.out.println("\nEnter username");
            String userName=scan.nextLine();
            if(userName.equals(username))
            {
                while(!isLogin)
                {
                    System.out.println("\nEnter your password");
                    String Password=scan.nextLine();
                    if(Password.equals(password))
                    {
                        System.out.println("\nLogin Sucessful");
                        isLogin=true;
                    }
                    else
                    {
                        System.out.println("\nLIncorrect Password");
                    }

                }
            }
            else
            {
                System.out.println("Username not found");
            }
        }
        return isLogin;
    }

    public void withdraw()
    {
        System.out.println("\nEnter the amount to be withdrawn:");
        Scanner scan=new Scanner(System.in);
        double amount = scan.nextDouble();
        try
        {
            if(balance>amount){
                balance-=amount;
                System.out.println("\nWithdrawl Sucessful");
                String trans = "Rs "+amount+"withdraw\n";
                transactionHistory = transactionHistory.concat(trans);
            }else
            {
                System.out.println("\nInsufficient Balance.");
            }
        }catch(Exception e)
        { }
    }


public void deposit()
{
    System.out.println("Enter amount to deposit: ");
    Scanner scan = new Scanner(System.in);
    double amount=scan.nextDouble();
    try
    {
        if(amount<=100000.00)
        {
            transactions++;
            balance+=amount;
            System.out.println("\nDeposit Sucessfully");
            String str = "Rs "+amount+" Deposited\n";
            transactionHistory=transactionHistory.concat(str);
        }
        else
        {
            System.out.println("\nLimit exceed");
        }
    } catch(Exception e)
    {
    }
}

public void transfer()
{
    Scanner scan = new Scanner(System.in);  
    System.out.println("\nEnter recipient name: ");
    String recepient = scan.nextLine();
    System.out.println("\nEnter amount to be transffered: ");
    double amount = scan.nextDouble();
    try
    {
        if(balance>=amount)
        {
            if(amount<=50000)
            {
                transactions++;
                balance-=amount;
                System.out.println("\nSucessfully transferred to "+recepient);
                String str = "Rs "+amount+" transferred to "+recepient+"\n";
                transactionHistory=transactionHistory.concat(str);
            }else
            {
                System.out.println("\nSorry Limit is 50,0000Rs");
            }
        }else
           System.out.println("\nInsufficient Balance.");
    }catch(Exception e){
    }
}

public void checkBalance(){
    System.out.println("\nRs "+balance);
}

public void transHist()
{
    if(transactions==0)
      System.out.println("\nEmpty!..");
    else
    System.out.println("\n"+transactionHistory);
}

}


public class AtmInterface {
     public static int takeInput(int lmt)
     {
        int input=0;
        boolean flag =false;
        while(!flag){
            try {
                Scanner scan = new Scanner(System.in);
                input = scan.nextInt();
                flag=true;
                if(flag&&input>lmt ||input <1){
                    System.out.println("Select the number between 1 to "+lmt);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter integer value only");
                flag = false;
            }
        }
        return input;
     }   
     public static void main(String[] args) {
        System.out.println("\nWelcome to My ATM \n");
        System.out.println("1.Register\n2.Exit");
        System.out.println("Enter your choice: ");
        int choice = takeInput(2);
        if(choice==1){
            Atm a = new Atm();
            a.register();
            while(true){
                System.out.println("\n1.Login\n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takeInput(2);
                if(choice==1){
                    if(a.login()){
                        System.out.println("\n\nWelcome back! "+a.name+"\n\n");
                        boolean isFinished =false;
                        while(!isFinished)
                        {
                            System.out.println("\n1.deposit\n2.Withdraw\n3.Transfer\n4.Transaction Hiatory\n5.check Balance\n6Exit");
                            System.out.println("Enter your choice : ");
                            int c = takeInput(6);
                            switch(c){
                                case 1:
                                    a.deposit();
                                    break;
                                case 2:
                                    a.withdraw();
                                    break;
                                case 3:
                                     a.transfer();
                                     break;
                                case 4:
                                    a.transHist();
                                    break;
                                case 5:
                                     a.checkBalance();
                                     break;
                                case 6:
                                    isFinished=true;
                                    System.exit(0);
                                default:
                                    System.out.println("\nWrong choice!");
                            }
                        }
                    }
                }else 
                System.exit(0);
            }
        }
     }
     

}
