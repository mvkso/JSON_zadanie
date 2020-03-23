package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.util.*;

public class Connection {
    String name,title;
    int userId,same_count=0;
    JSONArray user;
    JSONObject temp;
    Map<String, Integer> user_count = new HashMap<>();
    Map<String, Integer> tytuly = new HashMap<>();
    Map<String, Integer> tytuly_repeat = new HashMap<>();
    List<String> lista = new ArrayList<>();


    Connection(Users u,Posts p){
        for(int i=0; i< p.posts.length();i++){
            JSONObject posty= p.posts.getJSONObject(i);
            this.userId = posty.getInt("userId");
            p.posts.getJSONObject(i).append("Users",u.users.getJSONObject(userId-1));
            posty= p.posts.getJSONObject(i);

            this.title = posty.getString("title");

            this.user= posty.getJSONArray("Users");
            for(int a=0;a<user.length();a++) {
                this.temp = user.getJSONObject(a);
                this.name=temp.getString("name");
            }


            if(this.tytuly.containsKey(this.title)){
                this.tytuly.put(this.title,this.tytuly.get(this.title)+1);
                this.same_count+=1;
                this.tytuly_repeat.put(this.title,this.tytuly.get(this.title)+1);
            }else this.tytuly.put(this.title,1);

            if(this.user_count.containsKey(this.name)){
                this.user_count.put(this.name,this.user_count.get(this.name)+1);
            }else this.user_count.put(this.name,1);
        }
       //Z System.out.println(this.user_count);
    }
        HashMap<String,Integer> non_uniq(){
            System.out.println(String.format("Nieunikalnych tematow: %d",this.same_count));

        return (HashMap<String, Integer>) this.tytuly_repeat;
    }
        List<String> user_list(){
            List<String> temp1= new ArrayList<>(user_count.keySet());
            List<Integer> temp2= new ArrayList<>(user_count.values());
        for(int a=0;a<this.userId;a++){
        this.lista.add(a, String.format("%s napisal(a) %d postow",temp1.get(a),temp2.get(a)));

        }
            System.out.println("LISTA: "+this.lista);
        return (List<String>) this.lista;
        }

}
