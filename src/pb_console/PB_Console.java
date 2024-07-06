/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pb_console;

import java.net.MalformedURLException;
import java.util.Scanner;

/**
 *
 * @author nechi
 */
public class PB_Console {
    private static Scanner sc;
    private static ApiHandler api;
    private static Operations op;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        api = new ApiHandler();
        op = new Operations();
        sc = new Scanner(System.in);
        
        int choice = 0;
        
        while(true) {
            displayMenu();
            
            try {
                System.out.print("Please enter a choice: ");
                choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        op.printData();
                        break;
                    case 2:
                        op.createMostOccurringWhiteBalls();
                        break;
                    case 3:
                        op.createMostOccurringPBalls();
                        break;
                    case 4:
                        op.createQuickPick();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("You entered: " + choice + " Please Enter an integer value");
                sc.next();
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("====================================================");
        System.out.println("|             Powerball Calculations               |");
        System.out.println("====================================================");
        System.out.println("| Options:                                         |");
        System.out.println("|        1. Print Drawings                         |");
        System.out.println("|        2. Print Most Occurring White Balls       |");
        System.out.println("|        3. Print Most Occurring Power Balls       |");
        System.out.println("|        4. Create Quick Pick                      |");
        System.out.println("|        5. Exit                                   |");
        System.out.println("====================================================");
        System.out.println();
    }
}
