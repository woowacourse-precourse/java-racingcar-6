package racingcar.domain;

public class Car {

    private final String name;
    private int location;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getLocation(){
        return location;
    }
    public void moveForward(){
        location++;
    }

}
