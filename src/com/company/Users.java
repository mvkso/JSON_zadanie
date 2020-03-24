package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public  class Users{
    int id,temp;
    String username,name,email,phone,website,street,suite,city,zipcode,c_name,catchPhrase,bs;
    double lat,lng;
    JSONObject company,adress,geo,uzytkownik;
    JSONArray users;
    List<Double> lista_lat = new ArrayList<>();
    List<Double> lista_lng = new ArrayList<>();
    List<String> lista_name = new ArrayList<>();

    Users(String responseBody){
        this.users = new JSONArray(responseBody);
        for(int i = 0;i<this.users.length();i++){
            this.temp+=1;
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
            this.lat = geo.getDouble("lng");
            this.lng = geo.getDouble("lng");
            this.company = uzytkownik.getJSONObject("company");
            this.c_name = company.getString("name");
            this.catchPhrase = company.getString("catchPhrase");
            this.bs = company.getString("bs");
            this.lista_lat.add(i,this.lat);
            this.lista_lng.add(i,this.lng);
            this.lista_name.add(i,this.name);

           // System.out.println(id+" "+name+" "+username+" "+email+" "+phone+" "+website+" "+street+" "+suite+" "+city+" "+zipcode );
        }
       // System.out.println(users.getJSONObject(3));

    }
    void distance(){
        double dis,temp=0;
        int min=1;
        for(int i=0;i<this.temp;i++){
            System.out.println("\t\t EVERY DISTANCE FOR TESTING FOR USER "+(i+1)+"\n");
            for(int j=0;j<this.temp;j++){
                if(j!=i){

                    dis=Math.sqrt((this.lista_lat.get(i)-this.lista_lat.get(j))*(this.lista_lat.get(i)-this.lista_lat.get(j))+
                            (this.lista_lng.get(i)-this.lista_lng.get(j))*(this.lista_lng.get(i)-this.lista_lng.get(j)));
                    System.out.println(String.format("User %s : user2 is %s, distance: %f \n",this.lista_name.get(i),lista_name.get(j),dis));
                    if(temp==0 || dis<temp) {
                        temp = dis;
                        min=j+1;
                                        }
                    }
                }
            System.out.println("\t\t END OF A TESTING DISTANCE FOR USER "+(i+1)+"\n\nFINAL DISTANCE:");
            System.out.println(String.format("User %s : closest user is %s, distance: %f \n\n",this.lista_name.get(i),lista_name.get(min-1),temp));
            temp=0;
            }
        }

    }




