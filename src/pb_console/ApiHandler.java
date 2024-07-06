/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pb_console;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author nechi
 */
public class ApiHandler {
    private final URL url;

    public ApiHandler() throws MalformedURLException {
        url = URI.create("https://data.ny.gov/api/views/d6yy-54nr/rows.json?accessType=DOWNLOAD").toURL();
        
        try {
            String jsonResponse = getData(url);
            JSONArray dataArray = extractDataArray(jsonResponse);
            
            if (dataArray != null) {
                saveToFile(dataArray, "drawings.json");
            } else {
                System.out.println("NO 'data' array found in JSON");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getData(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("GET");
        int status = connection.getResponseCode();
        
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Return the JSON response as a string
            return response.toString();
        }
        
        return "Something went wrong";
    }
    
    private static JSONArray extractDataArray(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            // Extract the "data" field as an array
            JSONArray dataArray = jsonObject.getJSONArray("data");
            
            return dataArray;
        } catch (Exception e) {
            System.out.println("Error extracting 'data' array from JSON: " + e.getMessage());
            return null;
        }
    }
    
    private void saveToFile(JSONArray dataArray, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            
            file.write(dataArray.toString());
            
            System.out.println("Successfully saved JSON response to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving JSON response to file.");
            e.printStackTrace();
        }
    }
}
