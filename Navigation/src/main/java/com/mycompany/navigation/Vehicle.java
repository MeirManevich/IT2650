package com.mycompany.navigation;


public class Vehicle {
    private Location loc;
    private int maxFuel;
    private int currentFuel;
    private int mpg;
    
    public Vehicle(Location loc, int maxFuel, int mpg){
        this.loc = loc;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
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
    public int getMax(){
        return maxFuel;
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
            currentFuel = maxFuel;
    }
    
    public String toString(){
        return "Location: "+loc.getName()+", Current Fuel: "+currentFuel+
                ", Cooredinates: "+this.loc.getCoord()[0]+","+this.loc.getCoord()[1];
    }
}
