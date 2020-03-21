package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

public  class Users extends Main{

    Users(String responseBody){
        JSONArray users = new JSONArray(responseBody);
        for(int i = 0;i<users.length();i++){
            JSONObject uzytkownik = users.getJSONObject(i);
            int id = uzytkownik.getInt("id");
            String username = uzytkownik.getString("username");
            String name = uzytkownik.getString("name");

            String email = uzytkownik.getString("email");
            String phone = uzytkownik.getString("phone");
            String website = uzytkownik.getString("website");
            JSONObject adress = uzytkownik.getJSONObject("address");
            String street = adress.getString("street");
            String suite = adress.getString("suite");
            String city = adress.getString("city");
            String zipcode = adress.getString("zipcode");
            JSONObject geo = adress.getJSONObject("geo");
            String lat = geo.getString("lng");
            String lng = geo.getString("lng");
            JSONObject company = uzytkownik.getJSONObject("company");
            String c_name = company.getString("name");
            String catchPhrase = company.getString("catchPhrase");
            String bs = company.getString("bs");


            System.out.println(id+" "+name+" "+username+" "+email+" "+phone+" "+website+" "+street+" "+suite+" "+city+" "+zipcode );




        }


    }



}
