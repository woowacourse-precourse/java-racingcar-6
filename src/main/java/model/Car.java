package model;

public class Car {
    private final String carName;
    private int carState = 0;

    public Car(String name){
        this.carName = name;
    }
    public String getCar(){
        return carName;
    }
    public int getCarState(){
        return carState;
    }
    public int setCarState(int setCarState){
        this.carState = setCarState;
        return this.carState;
    }

}
