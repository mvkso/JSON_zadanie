package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Main {

    private static HttpURLConnection connection;
    public static void main(String[] args) {
        //METHOD 1: java.net.HttpURLConnection
    BufferedReader reader;
    String line;
    StringBuffer responseContent = new StringBuffer();
        try {
        URL url= new URL("https://jsonplaceholder.typicode.com/users");
        connection = (HttpURLConnection) url.openConnection();

        //Request setup
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status=connection.getResponseCode();
        // System.out.println(status );
        if (status > 299){
            reader= new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while((line = reader.readLine()) != null)  {
                responseContent.append(line);
            }
        }else {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null)  {
                responseContent.append(line+"\n");
            }
            reader.close();
        }
        System.out.println(responseContent.toString());

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        connection.disconnect();
    }
}
    String a="andrzej";

    Users maciek = new Users();
    Users.Address adres = maciek.new Address();

    public static String parse(String responseBody)     {

        JSONArray users = new JSONArray(responseBody);
        for(int i = 0;i<users.length();i++){
            JSONObject uzytkownik = users.getJSONObject(i);
            int id = uzytkownik.getInt("id");
            String name = uzytkownik.getString("name");
            String username = uzytkownik.getString("username");
            String email = uzytkownik.getString("email");

        }
        return null;
    }




}
