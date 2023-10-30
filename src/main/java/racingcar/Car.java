package racingcar;

public class Car {
    private static final int DISTANCE = 1;
    private final String name;
    private int location;

    Car(String name){
        this.name = name;
        this.location = 0;
    }

    public void move(){
        location += DISTANCE;
    }

    public int getLocation() {
        return location;
    }
}
