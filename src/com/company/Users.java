package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

public  class Users{
    int id;
    String username,name,email,phone,website,street,suite,city,zipcode,lat,lng,c_name,catchPhrase,bs;
    JSONObject company,adress,geo,uzytkownik;
    JSONArray users;

    Users(String responseBody){
        this.users = new JSONArray(responseBody);
        for(int i = 0;i<this.users.length();i++){
            this.uzytkownik = users.getJSONObject(i);
            this.id = uzytkownik.getInt("id");
            this.username = uzytkownik.getString("username");
            this.name = uzytkownik.getString("name");

            this.email = uzytkownik.getString("email");
            this.phone = uzytkownik.getString("phone");
            this.website = uzytkownik.getString("website");
            this.adress = uzytkownik.getJSONObject("address");
            this.street = adress.getString("street");
            this.suite = adress.getString("suite");
            this.city = adress.getString("city");
            this.zipcode = adress.getString("zipcode");
            this.geo = adress.getJSONObject("geo");
            this.lat = geo.getString("lng");
            this.lng = geo.getString("lng");
            this.company = uzytkownik.getJSONObject("company");
            this.c_name = company.getString("name");
            this.catchPhrase = company.getString("catchPhrase");
            this.bs = company.getString("bs");


           // System.out.println(id+" "+name+" "+username+" "+email+" "+phone+" "+website+" "+street+" "+suite+" "+city+" "+zipcode );




        }
       // System.out.println(users.getJSONObject(3));

    }



}
