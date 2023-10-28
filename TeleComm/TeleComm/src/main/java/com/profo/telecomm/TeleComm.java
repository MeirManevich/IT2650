package com.profo.telecomm;

public class TeleComm {

    public static void main(String[] args) {
        Owner dean = new Owner("Dean", "Martin");
        Owner jerry = new Owner("Jerry", "Lewis");
        
        Phone p1 = new Phone("216", "555-1234", dean);
        Phone p2 = new Phone("440", "555-8686", jerry);
        
        System.out.println(p1.receiveCall("800", "345-5454"));
        System.out.println(p2.receiveCall(p1));
        System.out.println(p2.receiveCall());
        System.out.println(p1.receiveCall(p2));
    }
}
