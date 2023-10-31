package racingcar.model;

public class Car {
    private String name;
    private int currentLocation;

    public Car(String name, int currentLocation){
        this.name=name;
        this.currentLocation=currentLocation;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void moveFoward(){
        currentLocation+=1;
    }
}
