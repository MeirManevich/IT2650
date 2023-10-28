package com.mycompany.navigation;


public class Vehicle {
    private Location loc;
    private int maxFuel;
    private int currentFuel;
    private int mpg;
    
    public Vehicle(Location loc, int maxFuel, int currentFuel, int mpg){
        this.loc = loc;
        this.maxFuel = maxFuel;
        this.currentFuel = currentFuel;
        this.mpg = mpg;
        
    }
    
    public void setLoc(Location newLoc){
        this.loc = newLoc;
    }
    public Location getLoc(){
        return loc;
    }

    public int getFuel(){
        return currentFuel;
    }
    public int getMpg(){
        return mpg;
    }
    public void setFuel(int newFuel){
        this.currentFuel = newFuel;
    }
    
    public void Fly(Location next){
        //subtract gallons for travel and set new location
        currentFuel -= (next.distance(this.getLoc())/mpg);
        setLoc(next);
    }
    
    public void Refeul() {
        //only refuel if location has gas and the tank isn't full
        if (this.loc.getHasGas() && this.currentFuel!=this.maxFuel){
            currentFuel = maxFuel;
        }
        else if (!this.loc.getHasGas()){
            System.out.println("This location has no fuel");
        }
        else if (this.currentFuel==this.maxFuel){
            System.out.println("You already have a full tank!");
        }
    }
    
    public String toString(){
        return "Location: "+loc.getName()+", Current Fuel: "+currentFuel+
                ", Cooredinates: "+this.loc.getCoord()[0]+","+this.loc.getCoord()[1];
    }
}
