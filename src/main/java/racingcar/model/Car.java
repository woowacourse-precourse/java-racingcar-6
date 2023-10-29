package racingcar.model;


public class Car {
    private final static int MOVING_STANDARD = 4;

    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }


    public int move(int randomNumber) {
        if (isMoveFront(randomNumber)) {
            location++;
        }
        return location;
    }

    private boolean isMoveFront(int randomNumber) {
        return randomNumber >= MOVING_STANDARD;
    }

}
