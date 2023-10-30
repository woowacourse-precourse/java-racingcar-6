package racingcar.controller;

public class Car {

    private String name;
    private int length;

    public Car(String name, int length){
        this.name = name;
        this.length = length;
    }

    public void move(){
        this.length +=1;
    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return length;
    }

    @Override
    public String toString(){
        return name +": "+length;
    }





}
