package com.jgitundu8.ai_review_agent;

import java.util.List;

/**
 * @author Jackson G. Mwaniki
 */
public class ExampleService {
    public void doSomething() {
        // TODO: Add authentication check
        System.out.println("Doing something risky...");
    }

    // 🚫 Scenario 2: No input validation
    public void transferMoney(String fromUser, String toUser, double amount) {
        System.out.println("Transferring $" + amount + " from " + fromUser + " to " + toUser);
        // Missing: validate users, amount, authentication
    }

    // 🔥 Scenario 3: Hardcoded credentials
    public boolean login(String username, String password) {
        String adminUser = "admin";
        String adminPass = "123456"; // Hardcoded password
        return username.equals(adminUser) && password.equals(adminPass);
    }

    // 📉 Scenario 4: Inefficient loop
    public void processList(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if (items.get(i).equals(items.get(j))) {
                    System.out.println("Duplicate found: " + items.get(i));
                }
            }
        }
    }

    // 🛑 Scenario 5: Poor exception handling
    public void riskyDatabaseCall() {
        try {
            // Simulate DB call
            throw new RuntimeException("DB connection failed");
        } catch (Exception e) {
            e.printStackTrace(); // Should log properly instead
        }
    }

    // 🚧 Scenario 6: Poor naming and unclear logic
    public void doAThing(int a, int b) {
        int x = a + b;
        if (x > 5) {
            x = x - 2;
        }
        System.out.println(x);
    }
}
