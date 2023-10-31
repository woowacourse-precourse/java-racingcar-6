package model;

public class Car {

    private final String carName;
    private int forwardCount;

    public Car(String carName){
        this.carName = carName;
        this.forwardCount = 0;
    }

    public String getCarName(){
        return this.carName;
    }
    public void addForwardCount(){
        this.forwardCount += 1;
    }
    public int getForwardCount(){
        return  this.forwardCount;
    }





}
