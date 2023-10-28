package com.profo.kennel;

public class Dog {
    
    private String name;
    private double weight;
    private Owner owner;
    
    Dog(String n, double w, Owner ow){
 
        name = n;
        weight = w;
        owner = ow;
    }

    
    public void eat(double amount){
        weight += amount;
    }

    public void poop(double am){
        weight -= am;
    }
    
    public String ownerName(){
        return owner.Name();
    }
    

    public String toString(){
        return name+", "+owner.Address();
    }

    public String speak(){
        if (weight < 25) 
            return "Yip yip!";
        else if (weight > 25 && weight < 50)
            return "Bark!";
        else if (weight > 50)
            return "WOOF!!!";
        else
            return "";
    }

    
}
