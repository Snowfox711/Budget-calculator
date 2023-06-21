
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int age = 0;
        int maritalStatus = 0;
        int dependentStatus = 0;
        int carOwnershipStatus = 0;
        double monthlyIncome;

        Scanner sc = new Scanner(System.in);
        boolean validInput = false;


        System.out.println("\n -------- Budget Calculator -------- ");
        System.out.println("\n -- Personal Information -- ");

        // -- Age Validation -- //
        while(!validInput){
            try{
                System.out.print("\n Please enter your age (10-100): ");
                age = sc.nextInt();
                while (age < 10 || age > 100) {
                    System.out.print("\n Please enter a valid age (10-100): ");
                    age = sc.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.println("\n Invalid input! Please enter a valid integer. ");
                // Clear the keyboard input
                sc.nextLine();
            }
        }

        validInput = false;


        // -- Marital Status Validation -- //
        while (!validInput){
            try{
                System.out.print("\n Please enter your marital status (1: Single, 2: Married): ");
                maritalStatus = sc.nextInt();
                while (maritalStatus < 1 || maritalStatus > 2) {
                    System.out.print("\n Please enter a valid marital status (1: Single, 2: Married): ");
                    maritalStatus  = sc.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\n Invalid input! Please enter a valid number. ");
                // Clear the keyboard input
                sc.nextLine();
            }
        }

        validInput = false;


        // -- Dependent Status Validation -- //
        while (!validInput){
            try{
                System.out.print("\n Please enter your dependent status (0-2 child): ");
                dependentStatus = sc.nextInt();
                while (dependentStatus < 0 || dependentStatus > 2) {
                    System.out.print("\n Please enter a valid dependent status (0-2 child): ");
                    dependentStatus  = sc.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\n Invalid input! Please enter a valid integer. ");
                // Clear the keyboard input
                sc.nextLine();
            }
        }

        validInput = false;


        // -- Car Ownership validation -- //
        while (!validInput){
            try{
                System.out.print("\n Please enter your car ownership status (0: Public Transport, 1: Self-Car): ");
                carOwnershipStatus = sc.nextInt();
                while (carOwnershipStatus < 0 || carOwnershipStatus > 1) {
                    System.out.print("\n Please enter a valid car ownership status (0: Public Transport, 1: Self-Car): ");
                    carOwnershipStatus  = sc.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\n Invalid input! Please enter a valid car ownership status. ");
                // Clear the keyboard input
                sc.nextLine();
            }
        }

        validInput = false;

        System.out.println("\n-----------------------------------------------------------------------");


        // -- Pass the data -- //
        if(maritalStatus == 1){
            maritalStatus = User.SINGLE;
        }else if(maritalStatus == 2){
            maritalStatus = User.MARRIED;
        }
        if(carOwnershipStatus == 0){
            carOwnershipStatus = User.PUBLIC_TRANSPORT_USER;
        } else if (carOwnershipStatus == 1) {
            carOwnershipStatus = User.CAR_OWNER;
        }

        User user = new User(age, maritalStatus, carOwnershipStatus, dependentStatus);


        // -- Suggested Expenses Budget -- //
        System.out.println("\n -- Suggested Expenses Budget -- ");
        System.out.println("\n In Johor Bahru area, the average expenses budget for you is RM " + user.getSuggestedExpenses());
        System.out.println("\n-----------------------------------------------------------------------");


        // -- Enter Monthly Income -- //
        System.out.println("\n --Enter your Monthly Income -- ");
        while (!validInput){
            try{
                System.out.print("\n Please enter your monthly income: ");
                monthlyIncome = sc.nextDouble();
                while (monthlyIncome <= 0){
                    System.out.print("\n Please enter a valid number: ");
                    monthlyIncome = sc.nextDouble();
                }
                user.setMonthlyIncome(monthlyIncome);
                validInput = true;
            }catch (Exception e){
                System.out.print("\n Invalid input! Please enter a valid number. ");
                // Clear the keyboard input
                sc.nextLine();
            }
        }

        System.out.println("\n-----------------------------------------------------------------------");


        // -- Compare with Suggested Expenses -- //
        System.out.println("\n -- Compare Result -- ");
        System.out.println("\n" + user.budgetAllocation() +
                           "\n" + user.compare());
        System.out.println("\n Please wait 5 second to check your report ‣♪ ···");
        System.out.println("\n-----------------------------------------------------------------------");

        //--------------Make the main thread sleep------------------//
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread Error");
            System.exit(0);
        }

        //----------------------User Information--------------------//
        System.out.println("\n" + user.toString());

        sc.close();
    }

}
