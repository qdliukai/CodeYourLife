package com.aoffer.shenxinfu;

class Animal{
    public void show(Dog dog){
        System.out.println("a");
    }

    public void show(){
        System.out.println("b");
    }
}

class Dog extends Animal{
    public void show(Dog dog){
        System.out.println("c");
    }

    public void show(){
        System.out.println("d");
    }
}

public class Base {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.show(new Dog());
        animal.show();
    }
}
