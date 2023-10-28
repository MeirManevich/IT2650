package com.profo.kennel;

public class Kennel {

    public static void main(String[] args) {
        
        Owner Meir = new Owner("Meir", "1989 Dewdrop Road", "Cleveland", "Ohio");
        Owner Squendil = new Owner("Squendil", "1991 Dewdrop Road", "Cleveland", "Ohio");
        
        Dog Amie = new Dog("Amie", 28, Meir);
        Dog Scarlet = new Dog("Scarlet", 35, Meir);
        Dog Owl = new Dog("Owl", 49, Squendil);

        
        System.out.println(Amie.speak());
        System.out.println(Scarlet.speak());
        System.out.println(Owl.speak());
        
        
        Amie.poop(5);
        Owl.eat(10);
        
        
        System.out.println(Amie.speak());
        System.out.println(Scarlet.speak());
        System.out.println(Owl.speak());
        System.out.println(Amie);
        System.out.println(Scarlet);
        System.out.println(Owl);


    }
}
