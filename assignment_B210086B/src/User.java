
import java.util.Formatter;

public class User {

    // -- Constructor -- //
    private int age;
    private int maritalStatus;
    private int dependentStatus;
    private int carOwnershipStatus;
    private double monthlyIncome;
    private double shortTermSavings;
    private double mediumTermSavings;
    private double longTermSavings;
    private double wants;
    private double needs;

    public User(int age, int maritalStatus, int dependentStatus, int carOwnershipStatus){
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.dependentStatus = dependentStatus;
        this.carOwnershipStatus = carOwnershipStatus;
        this.monthlyIncome = monthlyIncome;
    }


    // --- Constant Variable --- //
    static final int SINGLE = 1;
    static final int MARRIED = 2;
    static final int CAR_OWNER = 1;
    static final int PUBLIC_TRANSPORT_USER = 2;


    //Setter And Getter
    public void setAge(int age) {
        this.age = age;
    }
    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public void setDependentStatus(int dependentStatus) {
        this.dependentStatus = dependentStatus;
    }
    public void setCarOwnershipStatus(int carOwnershipStatus) {
        this.carOwnershipStatus = carOwnershipStatus;
    }
    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    public void setShortTermSavings(double shortTermSavings){
        this.shortTermSavings = shortTermSavings;
    }
    public void setMediumTermSavings(double mediumTermSavings){
        this.mediumTermSavings = mediumTermSavings;
    }
    public void setLongTermSavings(double longTermSavings){
        this.longTermSavings = longTermSavings;
    }
    public void setWants(double wants){
        this.wants = wants;
    }
    public void setNeeds(double needs){
        this.needs = needs;
    }

    public int getAge() {
        return age;
    }
    public int getMaritalStatus() {
        return maritalStatus;
    }
    public int getDependentStatus() {
        return dependentStatus;
    }
    public int getCarOwnershipStatus() {
        return carOwnershipStatus;
    }
    public double getMonthlyIncome() {
        return monthlyIncome;
    }
    public double getShortTermSavings(){
        return shortTermSavings;
    }
    public double getMediumTermSavings(){
        return mediumTermSavings;
    }
    public double getLongTermSavings(){
        return longTermSavings;
    }
    public double getWants(){
        return wants;
    }
    public double getNeeds(){
        return needs;
    }


    // -- Display The Suggested Expenses Budget For Johor Bahru -- //
    public double getSuggestedExpenses(){
        double suggestedExpenses = 0;

        if (age >= 60) {
            if (maritalStatus == SINGLE) {
                suggestedExpenses = 2330;
            }else if (maritalStatus == MARRIED) {
                suggestedExpenses = 3020;
            }
        } else if (age < 60) {             //Dependent Status: 0 for no child, 1 for 1 child, 2 for 2 children
            if (maritalStatus == SINGLE) {
                if (dependentStatus == 2) {
                    suggestedExpenses = 4940;
                } else if (dependentStatus == 1) {
                    suggestedExpenses = 4200;
                } else if (carOwnershipStatus == PUBLIC_TRANSPORT_USER) {
                    suggestedExpenses = 1760;
                } else if (carOwnershipStatus == CAR_OWNER) {
                    suggestedExpenses = 2290;
                }
            } else if (maritalStatus == MARRIED) {
                if (dependentStatus == 0) {
                    suggestedExpenses = 4110;
                } else if (dependentStatus == 1) {
                    suggestedExpenses = 5360;
                } else if (dependentStatus == 2) {
                    suggestedExpenses = 6100;
                }
            }
        }
        return (double) Math.round(suggestedExpenses * 100) / 100;
    }


    // -- Calculate Budget Allocation -- //
    public String budgetAllocation(){

        double savings = monthlyIncome * 0.1;

        shortTermSavings = mediumTermSavings = longTermSavings = savings ;
        wants = monthlyIncome * 0.25;
        needs = monthlyIncome * 0.45;
        return (" -- Suggested Budget Allocation --" +
                "\n\n Monthly Income: RM" + new Formatter().format("%.2f", monthlyIncome) +
                "\n\n Short-term Savings: RM" + new Formatter().format("%.2f", shortTermSavings) +
                "\n Medium-term Savings: RM" + new Formatter().format("%.2f", mediumTermSavings) +
                "\n Long-term Savings: RM" + new Formatter().format("%.2f", longTermSavings) +
                "\n Wants: RM" + new Formatter().format("%.2f", wants) +
                "\n Needs: RM" + new Formatter().format("%.2f", needs));
    }


    // -- Compare The Total Wants And Needs With The Suggested Expenses -- //
    public String compare(){
        double total = wants + needs;
        double exceed = total - getSuggestedExpenses();
        double leftover = getSuggestedExpenses() - total;
        if (total > getSuggestedExpenses()){
            return("\n You has exceeded your suggested expenses ,,Ծ‸Ծ,, " +
                   "\n The exceeded amount is RM" + new Formatter().format("%.2f", exceed));
        } else if (total <= getSuggestedExpenses()) {
            return ("\n You are within your suggested expenses (◍•ᴗ•◍) " +
                    "\n The leftover amount is RM"+ new Formatter().format("%.2f", leftover));
        }
        return null;
    }

    // -- Print User Profile -- //
    @Override
    public String toString() {
        return
                " -- Report for YOU ✐.ɴɪᴄᴇ ᴅᴀʏ 〰 --\n"+
                    "\n Age: " + age +
                    "\n Marital Status: " + maritalStatus +
                    "\n Dependent Status: " + dependentStatus +
                    "\n Car OwnerShip Status: " + carOwnershipStatus +
                    "\n\n"+ budgetAllocation() +
                    "\n"+ compare() +
                    "\n\n----------------------------------------------------------\n";
    }

}
