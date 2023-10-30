package racingcar;

public class Car {
    private String name;
    private int location;

    public Car(String input){
        name = input;
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
