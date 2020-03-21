package com.company;

import org.json.JSONObject;

public class Connection {

    Connection(Users u,Posts p){
        for(int i=0; i< p.posts.length();i++){
            JSONObject posty= p.posts.getJSONObject(i);
            int userId = posty.getInt("userId");
            p.posts.getJSONObject(i).append("Users",u.users.getJSONObject(userId-1));
            System.out.println(p.posts.getJSONObject(i)+"\n");
//            System.out.println(this.userId+"\n");
//            p.posts.put(u.users.getJSONObject(userId-1));
//            System.out.println(p.posts.getJSONObject(i)+"\n");
        }
    }
}
