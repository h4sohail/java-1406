import java.util.Scanner;

public class TaxProgram {
     public static void main(String args[]) {
         double income, fedTax, provTax, deductions;
         int dependents;

         final int INCOME_BRACKET_1 = 29_590;
         final int INCOME_BRACKET_2 = 59_180;

         final double TAX_RATE_1 = 0.17;
         final double TAX_RATE_2 = 0.26;
         final double TAX_RATE_3 = 0.29;
         final double PROV_TAX_RATE = 0.425;
         final double BASE_DEPENDANT_DEDUCTION = 160.5;
         final int PER_DEPENDANT_AMOUNT = 328;

         Scanner input = new Scanner(System.in);
         System.out.print("Please enter your taxable income: ");
         income = input.nextDouble();
         System.out.println();

         System.out.print("Please enter your number of dependents: ");
         dependents = input.nextInt();
         System.out.println();

         System.out.println("Here is your tax breakdown");
         System.out.println(String.format("Income: " + "$%.2f", income));
         System.out.println(String.format("Dependants: %d", dependents));
         System.out.println("----------------------------");

         if(income <= INCOME_BRACKET_1) {
             fedTax = income * TAX_RATE_1;
             double base = fedTax * PROV_TAX_RATE;
             deductions = BASE_DEPENDANT_DEDUCTION + (PER_DEPENDANT_AMOUNT * dependents);

             if(base > deductions){
                 provTax = base - deductions;
             }
             else{
                 provTax = 0;
             }

             System.out.println(String.format("Federal Tax: " + "$%.2f" , fedTax));
             System.out.println(String.format("Provincial Tax: " + "$%.2f", provTax));
             System.out.println(String.format("Total Tax: " + "$%.2f", fedTax + provTax));
         }

         if(income > INCOME_BRACKET_1 && income < INCOME_BRACKET_2){
             fedTax = (INCOME_BRACKET_1 * TAX_RATE_1) + (income - INCOME_BRACKET_1) * TAX_RATE_2;
             double base = fedTax * PROV_TAX_RATE;
             deductions = BASE_DEPENDANT_DEDUCTION + (PER_DEPENDANT_AMOUNT * dependents);

             if(base > deductions){
                 provTax = base - deductions;
             }
             else{
                 provTax = 0;
             }
             System.out.println(String.format("Federal Tax: " + "$%.2f" , fedTax));
             System.out.println(String.format("Provincial Tax: " + "$%.2f", provTax));
             System.out.println(String.format("Total Tax: " + "$%.2f", fedTax + provTax));
         }

         if(income >= INCOME_BRACKET_2){
             fedTax = (INCOME_BRACKET_1 * TAX_RATE_1) + (INCOME_BRACKET_1 * TAX_RATE_2) + (income - INCOME_BRACKET_2) * TAX_RATE_3;
             double base = fedTax * PROV_TAX_RATE;
             deductions = BASE_DEPENDANT_DEDUCTION + (PER_DEPENDANT_AMOUNT * dependents);

             if(base > deductions){
                 provTax = base - deductions;
             }
             else{
                 provTax = 0;
             }
             System.out.println(String.format("Federal Tax: " + "$%.2f" , fedTax));
             System.out.println(String.format("Provincial Tax: " + "$%.2f", provTax));
             System.out.println(String.format("Total Tax: " + "$%.2f", fedTax + provTax));
         }
     }
}
