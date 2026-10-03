
package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseService {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private HashMap<Category, Double> categoryTotals = new HashMap<>();
    private int nextId = 1;

    public void addExpense(String name, double amount, Category category) {
        Expense expense = new Expense(nextId++, name, amount, category, LocalDate.now());
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void displayExpenses() throws ExpenseException {
        if (expenses.isEmpty()) throw new ExpenseException("No expenses available.");
        System.out.println("\n===== ALL EXPENSES =====");
        for (Expense e : expenses) System.out.println(e);
    }

    public void deleteExpense(int id) throws ExpenseException {
        boolean removed = expenses.removeIf(e -> e.getId() == id);
        if (!removed) throw new ExpenseException("Expense ID not found.");
        System.out.println("Expense deleted successfully.");
    }

    public void totalExpense() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.println("\nTotal Expense = Rs." + total);
    }

    public void highestExpense() throws ExpenseException {
        if (expenses.isEmpty()) throw new ExpenseException("No expenses available.");
        Expense highest = expenses.stream().max((a,b) -> Double.compare(a.getAmount(), b.getAmount())).get();
        System.out.println("\n===== HIGHEST EXPENSE =====\n" + highest);
    }

    public void categoryWiseExpense() throws ExpenseException {
        if (expenses.isEmpty()) throw new ExpenseException("No expenses available.");
        categoryTotals.clear();
        for (Expense e : expenses) {
            categoryTotals.put(e.getCategory(), categoryTotals.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        System.out.println("\n===== CATEGORY-WISE EXPENSE =====");
        for (Category c : categoryTotals.keySet()) {
            System.out.println(c + " = Rs." + categoryTotals.get(c));
        }
    }
}
