package com.profo.kennel;

public class Owner {
    
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    
    Owner(String n, String st, String c, String s){
 
        name = n;
        streetAddress = st;
        city = c;
        state = s;
    }
    
    public String Name(){
        return name;
    }
    public String Address(){
        return streetAddress+" "+city+", "+state;
    }
}
