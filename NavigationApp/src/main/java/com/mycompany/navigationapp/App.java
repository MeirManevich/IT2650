package com.mycompany.navigationapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.Arrays;


public class App extends Application {
    Boolean gas = null;

    @Override
    public void start(Stage stage) {
        
        //Create Scenes
        AnchorPane mainPane = new AnchorPane();        
        Scene Main = new Scene(mainPane, 576, 432);
        Main.getStylesheets().add("style.css");
        
        AnchorPane createVehicle = new AnchorPane();        
        Scene Vehicle = new Scene(createVehicle, 576, 432);
        Vehicle.getStylesheets().add("style.css");
        
        AnchorPane addLocation = new AnchorPane();        
        Scene newLocation = new Scene(addLocation, 576, 432);
        newLocation.getStylesheets().add("style.css");
        
        //Opening: Vehicle scene
        Label fuelLbl = new Label("Max Fuel:");
        Label mpgLbl = new Label("Miles/Gallon:");
        TextField maxFuel = new TextField();
        TextField mpg = new TextField();
        Button create = new Button("Create Vehicle");
        Button travel =new Button("Next");
        Label infoLabel = new Label();
        Label infoLabel2 = new Label();
        Label infoLabel3 = new Label();
        Label locStatus = new Label();
        Label fuelStatus = new Label();
        Label coordStatus = new Label();
        Label loc = new Label();
        Label fuel = new Label();
        Label coord = new Label();
        Label error = new Label();
        Label instruct = new Label("Set the max fuel and mpg of your vehicle");
        appLocation Cleveland = new appLocation("Cleveland", new int[]{0,0}, true);
        
        
        
        
        appVehicle oop = new appVehicle(Cleveland, 0, 0);
        loc.setText("Location:");
        fuel.setText("Max Fuel:");
        coord.setText("Coordinates:");
        locStatus.setText(oop.getLoc().getName());
        fuelStatus.setText(String.valueOf(oop.getFuel()));
        coordStatus.setText(String.valueOf(oop.getLoc().getCoord()[0])+","+String.valueOf(oop.getLoc().getCoord()[1]));
       
        
        
        create.setOnAction(ActionEvent -> {
            try{
                //fuel = Integer.parseInt(maxFuel.getText());
                //mp = Integer.parseInt(mpg.getText());
                oop.setLoc(Cleveland);
                oop.setMaxFuel(Integer.parseInt(maxFuel.getText()));
                oop.setFuel(Integer.parseInt(maxFuel.getText()));
                oop.setMpg(Integer.parseInt(mpg.getText()));
                
                error.setText("");
                
                
                infoLabel.setText("Your vehicle has been constructed!");
                infoLabel2.setText("You begin in Cleveland.");
                infoLabel3.setText("Press next");
                fuelStatus.setText(String.valueOf(oop.getFuel()));
                instruct.setText("");
        
            }
            catch(Exception e){
                error.setText("Please enter whole numbers");
            }
        });
        
         
        
        
        
        
        travel.setOnAction(ActionEvent -> {
            if(infoLabel.getText()!= ""){
                
                stage.setScene(Main);
                maxFuel.clear();
                mpg.clear();
            }
            else{
                error.setText("Please create a vehicle first");
            }
        });
        
        AnchorPane.setBottomAnchor(instruct, 60.0);
        AnchorPane.setLeftAnchor(instruct, 20.0);
        AnchorPane.setTopAnchor(maxFuel, 20.0);
        AnchorPane.setLeftAnchor(maxFuel, 100.0);
        AnchorPane.setTopAnchor(mpg, 60.0);
        AnchorPane.setLeftAnchor(mpg, 100.0);
        AnchorPane.setTopAnchor(fuelLbl, 25.0);
        AnchorPane.setLeftAnchor(fuelLbl, 20.0);
        AnchorPane.setTopAnchor(mpgLbl, 65.0);
        AnchorPane.setLeftAnchor(mpgLbl, 20.0);
        AnchorPane.setBottomAnchor(infoLabel, 100.0);
        AnchorPane.setRightAnchor(infoLabel, 20.0);
        AnchorPane.setBottomAnchor(infoLabel2, 80.0);
        AnchorPane.setRightAnchor(infoLabel2, 20.0);
        AnchorPane.setBottomAnchor(infoLabel3, 60.0);
        AnchorPane.setRightAnchor(infoLabel3, 20.0);
        AnchorPane.setTopAnchor(error, 90.0);
        AnchorPane.setLeftAnchor(error, 20.0);
        AnchorPane.setBottomAnchor(create, 20.0);
        AnchorPane.setLeftAnchor(create, 40.0);
        AnchorPane.setBottomAnchor(travel, 20.0);
        AnchorPane.setRightAnchor(travel, 40.0);
        AnchorPane.setTopAnchor(loc, 20.0);
        AnchorPane.setRightAnchor(loc, 100.0);
        AnchorPane.setTopAnchor(fuel, 40.0);
        AnchorPane.setRightAnchor(fuel, 100.0);
        AnchorPane.setTopAnchor(coord, 60.0);
        AnchorPane.setRightAnchor(coord, 100.0);
        AnchorPane.setTopAnchor(locStatus, 20.0);
        AnchorPane.setRightAnchor(locStatus, 20.0);
        AnchorPane.setTopAnchor(fuelStatus, 40.0);
        AnchorPane.setRightAnchor(fuelStatus, 20.0);
        AnchorPane.setTopAnchor(coordStatus, 60.0);
        AnchorPane.setRightAnchor(coordStatus, 20.0);
        createVehicle.getChildren().addAll(maxFuel, mpg, 
                infoLabel, infoLabel2, infoLabel3, instruct,
                error,create, travel, locStatus, fuelStatus,
                loc, fuel, coord, coordStatus, fuelLbl, mpgLbl);
        
        //Main scene
        
        Label locStatus2 = new Label();
        Label fuelStatus2 = new Label();
        Label coordStatus2 = new Label();
        Label info1 = new Label();
        Label info2 = new Label();
        Label info3 = new Label();
        Label info4 = new Label();
        Label info5 = new Label();
        Label info6 = new Label();
        locStatus2.setText("Cleveland");
        fuelStatus2.setText(String.valueOf(oop.getFuel()));
        coordStatus2.setText(String.valueOf(oop.getLoc().getCoord()[0])+", "+String.valueOf(oop.getLoc().getCoord()[1]));

        ListView<appLocation> locations = new ListView();
        //locations.getItems().add(new appLocation("Cleveland", new int[]{0,0}, true));
        //locations.getItems().add(new appLocation("North Pole", new int[]{500,-100}, true));
        //locations.getItems().add(new appLocation("Campbell Hill", new int[]{-50,-50}, false));
        //locations.getItems().add(new appLocation("Tokyo", new int[]{-100,1000}, true));
        //locations.getItems().add(new appLocation("Chicago", new int[]{-200,75}, true));
        //locations.getItems().add(new appLocation("Erie PA", new int[]{150,0}, true));
        //locations.getItems().add(new appLocation("Allegheny National Forest", new int[]{300,-75}, false));
        
        try{
            File f = new File("locations.csv");
            FileReader fr = new FileReader(f);
            BufferedReader file = new BufferedReader(fr);
            
            String line;
            while((line = file.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int coords1 = Integer.parseInt(parts[1]);
                int coords2 = Integer.parseInt(parts[2]);
                gas = Integer.parseInt(parts[3])==1;
                locations.getItems().add(new appLocation(name, new int[]{coords1,coords2}, gas));
            }
            file.close();
        }   
        catch (FileNotFoundException ex) {
            info1.setText("Data file not found!");
        } 
        catch (IOException ex) {
            info1.setText("Problem with file!");
        }
    
        info4.setText("Location:");
        info5.setText("Gallons:");
        info6.setText("Coordinates:");
        
        Button go = new Button("Go");
        go.setOnAction(ActionEvent -> {
            try{
                info1.setText("");
                info2.setText("");
                info3.setText("");

                appLocation next = locations.getSelectionModel().getSelectedItem();
                

                oop.FlyOption(next);
                if (oop.FlyOption(next)==appVehicle.State.STATEA){
                    info1.setText("You have traveled "+next.distance(oop.getLoc())+" miles");
                    oop.Fly(next);
                    locStatus2.setText(oop.getLoc().getName());
                    fuelStatus2.setText(String.valueOf(oop.getFuel()));
                    coordStatus2.setText(String.valueOf(oop.getLoc().getCoord()[0])+", "+String.valueOf(oop.getLoc().getCoord()[1]));
                }

                //if in current location, print this message and continue loop
                else if(oop.FlyOption(next)==appVehicle.State.STATEB){
                    info1.setText("You are already in "+next.getName()+".");
                }

                //otherwise user must not have enough gas
                else{
                    info1.setText("It is "+next.distance(oop.getLoc())+" miles to travel to "+next.getName());
                    info2.setText("You do not have enough gas.");
                }
                //create exception for if none are selected to circumvent 
                //pressing button before location selection
            }
            catch(Exception e){
                info1.setText("Please select a valid location");
            }
        });
        
        Button refuel = new Button("Refuel");
        refuel.setOnAction(ActionEvent -> {
            oop.RefuelOption();
            if (oop.RefuelOption()==appVehicle.State.STATEA){
                oop.Refuel();
                fuelStatus2.setText(String.valueOf(oop.getFuel()));
                info3.setText("You've refuled");
            }
            else if (oop.RefuelOption()==appVehicle.State.STATEB){
                info3.setText("This location has no fuel.");
            }
        });
        
        Button restart = new Button("Restart");
        restart.setOnAction(ActionEvent ->{
            info1.setText("");
            info2.setText("");
            info3.setText("");
            infoLabel.setText("");
            infoLabel2.setText("");
            infoLabel3.setText("");
            stage.setScene(Vehicle);
        });
        
        Button remove = new Button("Remove");
        remove.setOnAction(ActionEvent -> {
            locations.getItems().remove(locations.getSelectionModel().getSelectedItem());
        });
        
        Button add = new Button("Add");
        add.setOnAction(ActionEvent -> {
            stage.setScene(newLocation);
        });
        
        Button save = new Button("Save");
        save.setOnAction(ActionEvent ->{
            try{
                        FileWriter fw = new FileWriter("locations.csv");
                        for(int i = 0; i < locations.getItems().size(); i++)
                        {
                            String addName = locations.getItems().get(i).getName();
                            int[] setCoord1 = locations.getItems().get(i).getCoord();
                            Boolean setGasBool = locations.getItems().get(i).getHasGas();
                            int setGasBinary = (setGasBool==true) ? 1:0;
                            fw.write(addName + "," + Arrays.toString(setCoord1).replace("[", "").replace("]","").replace(" ","") + "," + setGasBinary + "\n");
                        }
                        fw.close();
                    } catch (IOException ex) {
                        info1.setText("File failed to save data!");
                    }
        });
        
        AnchorPane.setTopAnchor(locations, 20.0);
        AnchorPane.setBottomAnchor(locations, 60.0);
        AnchorPane.setRightAnchor(locations, 30.0);
        AnchorPane.setBottomAnchor(restart, 20.0);
        AnchorPane.setLeftAnchor(restart, 20.0);
        AnchorPane.setBottomAnchor(go, 20.0);
        AnchorPane.setRightAnchor(go, 20.0);
        AnchorPane.setBottomAnchor(remove, 20.0);
        AnchorPane.setRightAnchor(remove, 120.0);
        AnchorPane.setBottomAnchor(add, 20.0);
        AnchorPane.setRightAnchor(add, 200.0);
        AnchorPane.setBottomAnchor(save, 20.0);
        AnchorPane.setRightAnchor(save, 280.0);
        AnchorPane.setBottomAnchor(refuel, 20.0);
        AnchorPane.setLeftAnchor(refuel, 100.0);
        AnchorPane.setTopAnchor(info4, 20.0);
        AnchorPane.setLeftAnchor(info4, 20.0);
        AnchorPane.setTopAnchor(info5, 40.0);
        AnchorPane.setLeftAnchor(info5, 20.0);
        AnchorPane.setTopAnchor(info6, 60.0);
        AnchorPane.setLeftAnchor(info6, 20.0);
        AnchorPane.setTopAnchor(locStatus2, 20.0);
        AnchorPane.setLeftAnchor(locStatus2, 100.0);
        AnchorPane.setTopAnchor(fuelStatus2, 40.0);
        AnchorPane.setLeftAnchor(fuelStatus2, 100.0);
        AnchorPane.setTopAnchor(coordStatus2, 60.0);
        AnchorPane.setLeftAnchor(coordStatus2, 100.0);
        AnchorPane.setTopAnchor(info1, 100.0);
        AnchorPane.setLeftAnchor(info1, 20.0);
        AnchorPane.setTopAnchor(info2, 140.0);
        AnchorPane.setLeftAnchor(info2, 20.0);
        AnchorPane.setTopAnchor(info3, 180.0);
        AnchorPane.setLeftAnchor(info3, 20.0);
        
        mainPane.getChildren().addAll(locations, restart, 
                locStatus2, coordStatus2, fuelStatus2, go,
                refuel, info1, info2, info3, info4,
                info5, info6, remove, add, save);
        
        
        //Add Location Stage
        Label newLocName = new Label("Name:");
        Label newCoord = new Label("Coordinates:");
        Label X = new Label("X:");
        Label Y = new Label("Y:");
        Label newGasBool = new Label("Has Gas?");
        Label info7 = new Label();
        TextField newLocNameInput = new TextField();
        TextField coordInput1 = new TextField();
        TextField coordInput2 = new TextField();
        Button gasTrue = new Button("Has Gas");
        Button gasFalse = new Button("No Gas");
        Button createLocation = new Button("Add Location");
        
        gasTrue.setOnAction(ActionEvent -> {
            gas = true;
        });
        gasFalse.setOnAction(ActionEvent -> {
            gas = false;
        });
        
        createLocation.setOnAction(ActionEvent -> {
            try{
                String name = newLocNameInput.getText();
                int[] newCoords = new int[]{Integer.parseInt(coordInput1.getText()),Integer.parseInt(coordInput2.getText())};
                
                if (!name.isBlank()){
                    locations.getItems().add(new appLocation(name, newCoords, gas));
                    info1.setText(name+" has been added");
                    stage.setScene(Main);
                    newLocNameInput.clear();
                    coordInput1.clear();
                    coordInput2.clear();
                    info7.setText("");
                    gas=null;
                }
                else{
                    info7.setText("Oops! Try entering info more accurately.");
                }
                
            }
            catch (Exception e){
                info7.setText("Oops! Try entering info more accurately.");
            }
        });
        
        AnchorPane.setTopAnchor(newLocName, 10.0);
        AnchorPane.setLeftAnchor(newLocName, 20.0);
        AnchorPane.setTopAnchor(newLocNameInput, 10.0);
        AnchorPane.setLeftAnchor(newLocNameInput, 60.0);
        AnchorPane.setTopAnchor(newCoord, 40.0);
        AnchorPane.setLeftAnchor(newCoord, 20.0);
        AnchorPane.setTopAnchor(X, 60.0);
        AnchorPane.setLeftAnchor(X, 60.0);
        AnchorPane.setTopAnchor(coordInput1, 60.0);
        AnchorPane.setLeftAnchor(coordInput1, 80.0);
        AnchorPane.setTopAnchor(Y, 80.0);
        AnchorPane.setLeftAnchor(Y, 60.0);
        AnchorPane.setTopAnchor(coordInput2, 80.0);
        AnchorPane.setLeftAnchor(coordInput2, 80.0);
        AnchorPane.setTopAnchor(newGasBool, 120.0);
        AnchorPane.setLeftAnchor(newGasBool, 20.0);
        AnchorPane.setTopAnchor(gasTrue, 140.0);
        AnchorPane.setLeftAnchor(gasTrue, 20.0);
        AnchorPane.setTopAnchor(gasFalse, 140.0);
        AnchorPane.setLeftAnchor(gasFalse, 90.0);
        AnchorPane.setTopAnchor(info7, 20.0);
        AnchorPane.setRightAnchor(info7, 20.0);
        AnchorPane.setBottomAnchor(createLocation, 20.0);
        AnchorPane.setRightAnchor(createLocation, 20.0);
        
        
        addLocation.getChildren().addAll(newLocName,newCoord, X, Y,
                newGasBool, gasTrue, gasFalse, info7, newLocNameInput,
                coordInput1,coordInput2,createLocation);
        
        //Setup Stage
        stage.setTitle("Navigation");
        stage.setScene(Vehicle);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}