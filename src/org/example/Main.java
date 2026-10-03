package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();
        int choice;

        do {
            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Display All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Calculate Total Expense");
            System.out.println("5. Find Highest Expense");
            System.out.println("6. Calculate Category-Wise Expense");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter expense name: ");
                        String name = sc.next();
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        System.out.println("1.FOOD 2.TRAVEL 3.SHOPPING 4.EDUCATION 5.BILLS 6.OTHER");
                        System.out.print("Enter category: ");
                        int ch = sc.nextInt();
                        Category cat = Category.OTHER;
                        if(ch==1) cat=Category.FOOD;
                        else if(ch==2) cat=Category.TRAVEL;
                        else if(ch==3) cat=Category.SHOPPING;
                        else if(ch==4) cat=Category.EDUCATION;
                        else if(ch==5) cat=Category.BILLS;
                        service.addExpense(name, amount, cat);
                        break;
                    case 2: service.displayExpenses(); break;
                    case 3:
                        System.out.print("Enter ID to delete: ");
                        service.deleteExpense(sc.nextInt());
                        break;
                    case 4: service.totalExpense(); break;
                    case 5: service.highestExpense(); break;
                    case 6: service.categoryWiseExpense(); break;
                    case 7: System.out.println("Thank you!"); break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (ExpenseException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 7);
    }
}
