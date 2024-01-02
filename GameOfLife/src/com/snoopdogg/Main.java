package com.snoopdogg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Create a grid with the specified dimensions
        Grid grid = new Grid(rows, cols);

        // Main game loop
        // Main game loop
        while (true) {
            System.out.println("Current State:");
            grid.displayGrid();
            grid.updateGrid();

            // Introduce a delay to slow down the animation (you can adjust the delay duration)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}