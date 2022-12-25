import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
public class MenuOption extends Account{
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();

    /* Check Login Informations  Account Number and Pin Number */

    public void login(){
        boolean checkLogin = true;
        do{
            try{
                details.put(475632147,6489);
                details.put(874521678,1498);

                System.out.println("Welcome to the ATM Machine!");

                System.out.print("Enter Your Account Number : ");
                setAccountNumber(sc.nextInt());

                System.out.print("Enter Your Pin Number : ");
                setPinNumber(sc.nextInt());

            }catch(Exception e){
                System.out.println("\nPlease enter only numbers\n");
                checkLogin = false;
            }
            for(Entry<Integer, Integer> entry : details.entrySet()){
                if(entry.getKey() == getAccountNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                    checkLogin = true;
                }      
                else{
                    checkLogin = false; 
                }           
            }
            if(!checkLogin){
                System.out.println("\nWrong Account Number or Pin Number.\n");
            }
               
        }while(checkLogin);
    }

    /* Account Type Menu */

    public void getAccountType(){
        System.out.println("Select Account you want to access : ");
        System.out.println("Type - 1 : Current Account");
        System.out.println("Type - 2 : Saving Account");
        System.out.println("Type - 3 : Exit");
        System.out.print("Enter your choice : "); 
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getCurrentAccount();
                break;
            
            case 2:
                getSavingAccount();
                break;
            
            case 3:
                System.out.println("Thank you for using this ATM!");
                break;
        
            default:
                System.out.println("\nInvalid Choice\n");
                getAccountType();
        }
    }

    /* Cuurent Account Menu */
    public void getCurrentAccount(){
        System.out.println("Current Account : ");
        System.out.println("Type - 1 : Check Balance");
        System.out.println("Type - 2 : Withdraw Amount");
        System.out.println("Type - 3 : Deposit Amount");
        System.out.println("Type - 4 : Exit");
        System.out.print("Enter your choice : "); 
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Current Account Balance : "+moneyFormat.format(getCurrentAccountBalance()));
                getAccountType();
                break;

            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCurrentDepoiteInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM!");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getCurrentAccount();
                break;
        }
    }

    /* Saving Account Menu */
    public void getSavingAccount(){
        System.out.println("Saving Account : ");
        System.out.println("Type - 1 : Check Balance");
        System.out.println("Type - 2 : Withdraw Amount");
        System.out.println("Type - 3 : Deposit Amount");
        System.out.println("Type - 4 : Exit");
        System.out.print("Enter your choice : "); 
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Saving Account Balance : "+moneyFormat.format(getSavingAccountBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepoiteInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM!");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getCurrentAccount();
                break;
        }
    }
}
