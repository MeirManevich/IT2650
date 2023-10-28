package com.mycompany.navigation;


public class Location {
    private String locName;
    private int[] coord;
    private boolean hasGas;
    
    public Location(String locName, int[] coord, boolean hasGas){
        this.locName = locName;
        this.coord = coord;
        this.hasGas = hasGas;
    }
    
    public boolean getHasGas(){
        return hasGas;
    }
    public int[] getCoord(){
        return coord;
    }
    public String getName(){
        return locName;
    }
    
    public int distance(Location a){
        //pythagorean theorum assuming traveling the shortest path
        //taking into account current location
        int dx =  this.coord[0]-a.coord[0];
        int dy = this.coord[1]-a.coord[1];
        return (int) Math.sqrt(dx*dx+dy*dy);
    }
    
}
