package com.company;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class Main {

    private static HttpURLConnection connection;
    private static HttpURLConnection connection2;

    public static void main(String[] args) {
        //METHOD: java.net.HttpURLConnection
        HashMap<Integer,Integer> mapa = new HashMap<>();
        Users parse = null;
        Posts parse_post = null;
        Connection c = null;
        BufferedReader reader;
        String line, line2;

        StringBuffer responseContent = new StringBuffer();
        StringBuffer responseContent2 = new StringBuffer();

        ////////POSTS


        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            connection = (HttpURLConnection) url.openConnection();


            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            // System.out.println(status );
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    responseContent.append(line + "\n");
                }
                reader.close();
            }
            parse = new Users(responseContent.toString());
            System.out.println("TEST -> pobrano dane o uzytkownikach: "+parse.users+"\n");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        ////////////////////POSTS

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            connection2 = (HttpURLConnection) url.openConnection();


            //Request setup
            connection2.setRequestMethod("GET");
            connection2.setConnectTimeout(5000);
            connection2.setReadTimeout(5000);

            int status = connection2.getResponseCode();
            // System.out.println(status );
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection2.getErrorStream()));
                while ((line2 = reader.readLine()) != null) {
                    responseContent2.append(line2);
                }
            } else {
                reader = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
                while ((line2 = reader.readLine()) != null) {
                    //System.out.println(line2);
                    responseContent2.append(line2 + "\n");
                }
                reader.close();
            }
            parse_post = new Posts(responseContent2.toString());
            System.out.println("\nTEST -> pobrano dane o postach: "+parse_post.posts+"\n\n");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection2.disconnect();
        }
        try{
            c= new Connection(parse,parse_post);
            System.out.println("Pojedyncze drukowanie w klasie Main polaczonych danych o postach i odpowiednich userach: \n"+parse_post.posts+"\n");



        }catch (JSONException e)
        {
            e.printStackTrace();
        }
       // System.out.println(parse_post.posts.getJSONObject(99)+"\n");
       c.user_list();
        c.non_uniq();
        parse.distance();


        }
    }

