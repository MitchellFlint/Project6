/* File: MushroomPlanner.java
 * By: Mitchell Flint
 * Date: April 13th 2022
 *
 * Description: This program takes the input of the user to create a cool pattern
 * from a given set of rules (called automaton)
 */

import java.util.Scanner;

public class Automaton {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numCells; // number of cells in the array
        int steps; // number of steps in the calculation
        int[] cells; // the current array

        System.out.println("Welcome to the cellular automaton simulation!");

        // prompts user to enter number of cells
        System.out.print("Enter number of cells (<= 80): ");
        numCells = input.nextInt();

        // sets the length of the array
        cells = new int[numCells];

        // prompts user to enter the number of steps
        System.out.print("Enter number of time steps: ");
        steps = input.nextInt();

        // prompts user to enter index of cells to contain "1"
        System.out.print("Enter the index of occupied cells (negative index to end): ");
        for (int i; true; ) {
            i = input.nextInt();

            if (i < 0) break; // if the user enters a negative value

            cells[i] = 1;
        }

        // new line
        System.out.println("\n");

        // prints top reference line
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i % 10);
        }

        // new line
        System.out.println();

        // displays the pattern
        for (int i = 0; i <= steps; i++) {
            displayCells(cells); // shows the current row

            cells = updateCells(cells); // updates given parameters

            System.out.println(); // prints new line
        }
    }

    // int updateCells(int[] data)
    // data is a 1d array
    // updateCells() returns new values to the cells of
    // an array using the given parameters

    public static int[] updateCells (int[] data) {
        int[] newCells = new int[data.length];

        for(int i = 1; i < (data.length - 1); i++) {

            // parameters

            if (data[i-1] == 1 && data[i] == 1 && data[i+1] == 1) newCells[i] = 0;
            else if (data[i-1] == 1 && data[i] == 1 && data[i+1] == 0) newCells[i] = 1;
            else if (data[i-1] == 1 && data[i] == 0 && data[i+1] == 1) newCells[i] = 1;
            else if (data[i-1] == 1 && data[i] == 0 && data[i+1] == 0) newCells[i] = 1;
            else if (data[i-1] == 0 && data[i] == 1 && data[i+1] == 1) newCells[i] = 0;
            else if (data[i-1] == 0 && data[i] == 1 && data[i+1] == 0) newCells[i] = 1;
            else if (data[i-1] == 0 && data[i] == 0 && data[i+1] == 1) newCells[i] = 1;
            else newCells[i] = 0;
        }

        return newCells;
    }

    // int displayCells(int[] data)
    // data is an array
    // displayCells() prints 0s in an array as " " and 1s as "#"
    // of 1d arrays and returns nothing

    public static void displayCells(int[] data) {

        // goes through the array and prints the values
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) System.out.print(" ");
            else System.out.print("#");
        }
    }
}