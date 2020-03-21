package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

public class Posts{
    int userId,id;
    String title,body;
    JSONArray posts;
    JSONObject posty;
    Posts(String responseBody){
        this.posts = new JSONArray(responseBody);

        for (int i = 0; i < posts.length(); i++) {
            this.posty = posts.getJSONObject(i);
            this.userId = posty.getInt("userId");
            this.id = posty.getInt("id");
            this.title = posty.getString("title");
            this.body = posty.getString("body");


            System.out.println(userId + " " + id + "\n" + title +"\n"+ body +"\n");


        }


    }
}
