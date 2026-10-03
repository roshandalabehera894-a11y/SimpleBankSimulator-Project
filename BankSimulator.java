import java.util.Scanner;

public class BankSimulator {

    static double availableBalance = 50; // THIS IS CLASS VARIABLE.

    public static void main(String [] args){
        System.out.println("   \n" +
                           "******/🏦Welcome to RD BankBank🏦\\******\n" +
                           "  ");

        Scanner input = new Scanner(System.in);

        boolean isRunning = true;

        UserIdChecker();

        System.out.println("   \n" +
                           "Choice 1 : Check Available Balance\n"+
                           "Choice 2 : Deposit Amount\n" +
                           "Choice 3 : Withdraw Amount\n" +
                           "Choice 4 : Exit the Window\n" +
                           "  ");

        while (isRunning == true) {

            System.out.print("  \n" +
                             "Enter your choice(1/2/3/4): ");
            int choice = input.nextInt();
            System.out.println(" ");

            if (choice == 1) {
                CheckBalance();
            } else if (choice == 2) {
                DepositMoney();
            } else if (choice == 3) {
                WithdrawMoney();
            } else {
                System.out.println("  \n" +
                                   "Thank you for banking with RD Bank.\n" +
                                   "We appreciate your trust and look forward to serving you again.\n" +
                                   "Have a great day.\n" +
                                   "  ");

                isRunning = false; // Reassingment of isRunning.
            }
        }
    }
    // THIS IS THE USER ID METHOD IN WHICH USER HAVE TO GIVE THERE USER ID INFORMATION TO ACCESS THEIR BANK ACCOUNT.
    public static void UserIdChecker(){
            Scanner input = new Scanner(System.in);

            int trails = 3;

            System.out.print("Enter your User Id: ");
            String userId = input.next();
            int countChar = userId.length();
            System.out.print("Enter your Six digit PIN: ");
            String pin = input.next();
            int countPin = pin.length();

            if (!(countChar>0) && !(countChar<16)) {
                while (trails > 1 && (!(countChar>0) && !(countChar<16))) {

                    System.out.println("Length of UserId should be in between 0-16 characters.");
                    System.out.print("Re-enter your User Id: ");
                    userId = input.next();
                    countChar = userId.length();
                    trails -= 1;
                }
            }else if (!(countPin==6)){
                while (trails > 1 && (!(countPin==6))){

                    System.out.println("Your PIN should have only six digits.");
                    System.out.print("Enter your Six digit PIN: ");
                    pin = input.next();
                    countPin = pin.length();
                    trails -= 1;
                }
            }else{
                trails -= 1;
            }
    }

    // THIS IS AVAILABLE BALANCE CHECKING METHOD IN WHICH USER CAN CHECK THERE CURRENT BALANCE.
    public static double CheckBalance(){

        System.out.println(" \n" +
                           "💰💰Your Available balance is: ₹"+ availableBalance+"\n" +
                           " ");
        return availableBalance;
    }

    // THIS ID MONEY DEPOSIT METHOD IN WHICH MONEY IS CREDITED TO ACCOUNT BY USER.
    public static double DepositMoney(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount of deposit: ₹");
        double depositAmount = input.nextDouble();

        if(depositAmount > 0) {
            availableBalance = availableBalance + depositAmount;
        }else{
            availableBalance = availableBalance + 0;
        }
        return availableBalance;
    }

    // THIS IS MONEY WITHDRAWAL METHOD IN WHICH MONEY IS DEBITED FROM ACCOUNT BY USER.
    public static double WithdrawMoney(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount of withdrawal: ₹");
        double withdrawAmount = input.nextDouble();

        if (withdrawAmount > 0){
            availableBalance = availableBalance - withdrawAmount;
        }else{
            availableBalance = availableBalance - 0;
        }
        return availableBalance;
    }

}
