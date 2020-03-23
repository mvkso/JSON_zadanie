package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Posts{
    int userId,id;
    String title,body;
    JSONArray posts;
    JSONObject posty;
    Map<String, Integer> tytuly_uniq = new HashMap<String,Integer>();
    Map<String, Integer> tytuly_repeat = new HashMap<String,Integer>();
    Map<Integer, Integer> user_count = new HashMap<Integer,Integer>();
    Posts(String responseBody){
        this.posts = new JSONArray(responseBody);

        for (int i = 0; i < posts.length(); i++) {
            this.posty = posts.getJSONObject(i);
            this.userId = posty.getInt("userId");
            this.id = posty.getInt("id");
            this.title = posty.getString("title");
            this.body = posty.getString("body");
            if(this.tytuly_uniq.containsKey(this.title)){
                this.tytuly_uniq.put(this.title,this.tytuly_uniq.get(this.title)+1);
                this.tytuly_repeat.put(this.title,this.tytuly_uniq.get(this.title)+1);
            }else this.tytuly_uniq.put(this.title,1);





           // System.out.println(userId + " " + id + "\n" + title +"\n"+ body +"\n");


        }

       // System.out.println(this.user_count);
        //System.out.println(posts.getJSONObject(3));

    }
}
