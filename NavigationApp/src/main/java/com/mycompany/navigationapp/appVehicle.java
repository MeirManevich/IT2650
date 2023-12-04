package com.mycompany.navigationapp;


public class appVehicle {
    private appLocation loc;
    private int maxFuel;
    private int currentFuel;
    private int mpg;
    
    public appVehicle(){
        
    }
    
    public appVehicle(appLocation loc, int maxFuel, int mpg){
        this.loc = loc;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
        this.mpg = mpg;
        
    }
    
    public void setLoc(appLocation newLoc){
        this.loc = newLoc;
    }
    public appLocation getLoc(){
        return this.loc;
    }

    public int getFuel(){
        return this.currentFuel;
    }
    public int getMax(){
        return this.maxFuel;
    }
    public int getMpg(){
        return this.mpg;
    }
    public void setFuel(int newFuel){
        this.currentFuel = newFuel;
    }
    
    public void setMaxFuel(int newFuel){
        this.maxFuel = newFuel;
        this.currentFuel = newFuel;
    }
    
    public void setMpg(int newMpg){
        this.mpg = newMpg;
    }

    enum State {
        STATEA,
        STATEB,
        STATEC
    }
    
    public State FlyOption(appLocation next){
        if (next.distance(this.getLoc())<(this.getFuel()*this.getMpg()) && !this.getLoc().getName().equals(next.getName())){
            return State.STATEA;
        }
        else if(this.getLoc().getName().equals(next.getName())){
            return State.STATEB;
        }
        else{
            return State.STATEC;
        }
    }
    public void Fly(appLocation next){
        //subtract gallons for travel and set new location
        currentFuel -= (next.distance(this.getLoc())/mpg);
        setLoc(next);
    }
    
    public State RefuelOption() {
        if(this.getLoc().getHasGas() && this.getFuel()!=this.getMax()){
            return State.STATEA;
        }
        else if (!this.getLoc().getHasGas()){
            return State.STATEB;
        }
        else{
            return State.STATEC;
        }
    }

    public void Refuel(){
        currentFuel = maxFuel;
    }
    
}
