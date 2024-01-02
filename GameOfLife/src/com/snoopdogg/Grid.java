package com.snoopdogg;

import java.util.Random;

public class Grid {
    private Cell[][] cells;

    public Grid(int rows, int cols) {
        cells = new Cell[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        Random random = new Random();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                // Randomly set the cell to be alive (true) or dead (false)
                cells[i][j] = new Cell();
                cells[i][j].setAlive(random.nextBoolean());
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].isAlive() ? '*' : '.');
                System.out.print(" ");  // Add space between cells for better visibility
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println(); // Add an extra line for better visibility
    }

    private int countLiveNeighbors(int row, int col) {
        int liveNeighbors = 0;

        // Define the eight possible neighbors' relative positions
        int[][] neighbors = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // Check each neighbor position
        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];

            // Check if the neighbor position is within the grid boundaries
            if (newRow >= 0 && newRow < cells.length && newCol >= 0 && newCol < cells[0].length) {
                // Check if the neighbor cell is alive
                if (cells[newRow][newCol].isAlive()) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }

    public void updateGrid() {
// Create a copy of the current grid to store the next generation
        Cell[][] nextGeneration = new Cell[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                // Apply the rules of Conway's Game of Life
                if (cells[i][j].isAlive()) {
                    // Cell is alive
                    nextGeneration[i][j] = new Cell();
                    // Rule: Any live cell with fewer than two live neighbors or more than three dies
                    // Rule: Any live cell with two or three live neighbors lives on
                    nextGeneration[i][j].setAlive(liveNeighbors >= 2 && liveNeighbors <= 3);
                } else {
                    // Cell is dead
                    nextGeneration[i][j] = new Cell();
                    if (liveNeighbors == 3) {
                        // Rule: Any dead cell with exactly three live neighbors becomes alive
                        nextGeneration[i][j].setAlive(true);
                    }
                }
            }
        }

        // Update the current grid with the next generation
        cells = nextGeneration;
    }
}
