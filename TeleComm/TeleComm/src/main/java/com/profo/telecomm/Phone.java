package com.profo.telecomm;

public class Phone {
    private String areaCode;
    private String phoneNumber;
    private Owner owner;

    public Phone(String areaCode, String phoneNumber, Owner owner) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }
    
    public String getOwnerName() {
        return owner.getName();
    }
    
    public String receiveCall(String area, String number){
        return "Call from: (" + area + ")" + number;
    }
    
    public String receiveCall(Phone phone){
        return "Call from: " + phone.getOwnerName();
    }
    
    public String receiveCall(){
        return "Wring!!! Wring!!!";
    }

    @Override
    public String toString() {
        return owner.getName() + ": (" + areaCode + ")" + phoneNumber;
    }
    
    
}
