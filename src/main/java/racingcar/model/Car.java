package racingcar.model;


public class Car {
    private final static int MOVING_STANDARD = 4;

    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }


    public void move(int randomNumber) {
        if (isMoveFront(randomNumber)) {
            location++;
        }
    }

    private boolean isMoveFront(int randomNumber) {
        return randomNumber >= MOVING_STANDARD;
    }


    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
