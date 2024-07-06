/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pb_console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author nechi
 */
public class Operations {

    private String[] numbers;
    private List<String[]> drawingsStrArr = new ArrayList<>();
    private List<int[]> drawings = new ArrayList<>();

    public void printData() {
        String fileName = "drawings.json"; // Replace with your file name

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(line); // Parse line as JSONArray
                processJsonArray(jsonArray); // Process each JSONArray
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void processJsonArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i); // Get inner array
            System.out.println("Date: " + innerArray.get(8).toString()
                    + " Combo: " + innerArray.get(9).toString());
            // Process or access elements of innerArray as needed
        }
    }

    public void createMostOccurringWhiteBalls() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        String fileName = "drawings.json"; // Replace with your file name

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(line); // Parse line as JSONArray

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray innerArray = jsonArray.getJSONArray(i); // Get inner array

                    // Check if the inner array has at least 10 elements
                    if (innerArray.length() > 9) {
                        // Get the element at index 9 (10th element) of the inner array
                        Object combos = innerArray.get(9);

                        // Cast the element to a string
                        if (combos instanceof String) {
                            String combosString = (String) combos;

                            String[] numbers = combosString.split(" ");

                            for (int j = 0; j < numbers.length - 1; j++) {
                                try {
                                    int num = Integer.parseInt(numbers[j]);

                                    frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number format: " + numbers[j]);
                                }
                            }
                        } else {
                            System.out.println("Combos at index " + i + " is not a string: " + combos.getClass().getName());
                        }
                    }
                }
            }

            printMostOccurringWhiteBalls(frequencyMap);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private void printMostOccurringWhiteBalls(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> num : frequencyMap.entrySet()) {
            System.out.println("Ball: " + num.getKey() + ", Occurrences: " + num.getValue());
        }
    }

    public void createMostOccurringPBalls() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        String fileName = "drawings.json"; // Replace with your file name

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(line); // Parse line as JSONArray

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray innerArray = jsonArray.getJSONArray(i); // Get inner array

                    // Check if the inner array has at least 10 elements
                    if (innerArray.length() > 9) {
                        // Get the element at index 9 (10th element) of the inner array
                        Object combos = innerArray.get(9);

                        // Cast the element to a string
                        if (combos instanceof String) {
                            String combosString = (String) combos;

                            String[] numbers = combosString.split(" ");
                            try {
                                int num = Integer.parseInt(numbers[numbers.length - 1]);

                                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number format: " + numbers[numbers.length - 1]);
                            }
                        } else {
                            System.out.println("Combos at index " + i + " is not a string: " + combos.getClass().getName());
                        }
                    }
                }
            }

            printMostOccurringPBalls(frequencyMap);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private void printMostOccurringPBalls(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> num : frequencyMap.entrySet()) {
            System.out.println("Ball: " + num.getKey() + ", Occurrences: " + num.getValue());
        }
    }

    public void createQuickPick() {
        String fileName = "drawings.json"; // Replace with your file name

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(line); // Parse line as JSONArray

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray innerArray = jsonArray.getJSONArray(i); // Get inner array

                    // Check if the inner array has at least 10 elements
                    if (innerArray.length() > 9) {
                        // Get the element at index 9 (10th element) of the inner array
                        Object combos = innerArray.get(9);

                        // Cast the element to a string
                        if (combos instanceof String) {
                            String combosString = (String) combos;

                            numbers = combosString.split(" ");

                            drawings.add(parseNumbers(numbers));
                        } else {
                            System.out.println("Combos at index " + i + " is not a string: " + combos.getClass().getName());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        createCombination();
    }

    private void createCombination() {
        int[] combo = new int[6];
        int[] white = new int[5];
        Boolean neverSeen = false;

        while (!neverSeen) {
            int count = 0;
            
            while (count < 5) {
                int num = randomNum();
                white[count] = num;

                count++;
            }
            
            count = 0;
            
            Arrays.sort(white);

            for (int i = 0; i < combo.length - 1; i++) {
                combo[i] = white[i];
            }
            
            combo[5] = randomPNum();
            
            neverSeen = checkIfExists(combo);
        }

        System.out.println("Combo");
        for (int i = 0; i < combo.length; i++) {
            System.out.print(combo[i] + " ");
        }
        System.out.println();
    }
    
    public Boolean checkIfExists(int[] combo) {
        Boolean neverSeen = true;
        
        for (int[] drawing : drawings) {
            if (Arrays.equals(combo, drawing)) {
                System.out.println(combo + " " + drawing);
                neverSeen = false;
                return neverSeen;
            }
        }
        
        return neverSeen;
    }

    private int[] parseNumbers(String[] numbers) {
        int[] parsedNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            try {
                parsedNumbers[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing string to int: " + numbers[i]);
            }
        }

        return parsedNumbers;
    }

    private int randomNum() {
        return (int) Math.floor((Math.random() * 69) + 1);
    }

    private int randomPNum() {
        return (int) Math.floor((Math.random() * 26) + 1);
    }
}
