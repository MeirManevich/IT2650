package com.mycompany.navigation;
import java.util.*;
import java.util.Scanner;

public class Navigation {

    public static void main(String[] args) {
        //Creating new locations to travel to
        Location cleveland = new Location("Cleveland", new int[]{0,0}, true);
        Location northPole = new Location("North Pole", new int[]{500,-100}, true);
        Location campbellHill = new Location("Campbell Hill", new int[]{-50,-50}, false);
        Location tokyo = new Location("Tokyo", new int[]{-100,1000}, true);
        Location chicago = new Location("Chicago", new int[]{-200,75}, true);
        Location eriePA = new Location("Erie PA", new int[]{150,0}, true);
        Location allegForest = new Location("Allegheny National Forest", new int[]{300,-75}, false);
    
        //All locations exist inside an arrayist to iterate and compare easily
        ArrayList<Location> Destinations = new ArrayList<Location>();
        Collections.addAll(Destinations, cleveland, northPole, campbellHill, 
                tokyo, chicago, eriePA, allegForest);
    
    
        //A scanner item to read output from user and assign to variables
        Scanner createVehicle = new Scanner(System.in);
        System.out.println("Create your vehicle! Enter the maximun fuel capacity first: ");
        //Setting maximum gas
        int max = Integer.parseInt(createVehicle.nextLine());
        System.out.println("Excellent! Now set your efficiency in mpg: ");
        //Setting gas efficiency
        int mp =Integer.parseInt(createVehicle.nextLine());
        
        //create a vehicle with those attributes
        Vehicle oop = new Vehicle(cleveland, max, mp);
        
        System.out.println("Your vehicle has been constructed! "
                + "You begin in Cleveland with a full tank of gas."
                + " Where to next?");
        System.out.println("Your options are:");
        for(Location a : Destinations){
            System.out.println(a.getName());
        }
        
        //now starts the loop that will allow trhe use to travel 
        //until there is no gas
        while (oop.getFuel()>0){
            //assign user location choice to variable to compare to list
            String locChoice = createVehicle.nextLine();

            //actual location to be used for traveling, only if
            //user choice matches a valid location
            Location next = null;
            
            //foreach loop
            for(Location findloc : Destinations){
                //if there is a match, 'next' is assigned the location and we move on
                if (findloc.getName().equals(locChoice)){
                    next = findloc;
                    break;
                }
            }
            
            //if none match, print error and continue, will restart loop
            if(next==null){
                    System.out.println("You cannot go there! Please choose a valid location.");
                    continue;
                }
            
            //if the match is not too far away to travel and user isn't already there, then travel
            if (next.distance(oop.getLoc())<(oop.getFuel()*oop.getMpg()) && !oop.getLoc().getName().equals(next.getName())){
                System.out.println("It is "+next.distance(oop.getLoc())+" miles to travel to "+next.getName());
                System.out.println("Traveling to "+next.getName());
                oop.Fly(next);
                System.out.println(oop);
            }
            
            //if in current location, print this message and continue loop
            else if(oop.getLoc().getName().equals(next.getName())){
                System.out.println("You are already in "+next.getName()+".");
            }
            
            //otherwise user must not have enough gas
            else{
                System.out.println("You do not have enough gas."
                + " With your fuel efficiency,"
                + " it would require "+next.distance(oop.getLoc())/oop.getMpg()
                + " gallons. You only have " +oop.getFuel()+ " gallons left."); 
            }
            
            //refuel option
            if (oop.getLoc().getHasGas() && oop.getFuel()!=oop.getMax()){
                System.out.println("Would you like to refuel? y/n");
                if(createVehicle.nextLine().equals("y")){
                    oop.Refeul();
                    System.out.println(oop);
                }
            }
            else if (!oop.getLoc().getHasGas()){
                System.out.println("This location has no fuel.");
            }
            
        }
       
    }
    
}
