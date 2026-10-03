
    package org.example;

import java.time.LocalDate;

    public class Expense {
        private int id;
        private String name;
        private double amount;
        private Category category;
        private LocalDate date;

        public Expense(int id, String name, double amount, Category category, LocalDate date) {
            this.id = id;
            this.name = name;
            this.amount = amount;
            this.category = category;
            this.date = date;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getAmount() { return amount; }
        public Category getCategory() { return category; }
        public LocalDate getDate() { return date; }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Amount: Rs." + amount + " | Category: " + category + " | Date: " + date;
        }
    }

