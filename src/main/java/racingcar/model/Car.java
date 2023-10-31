package racingcar.model;

public class Car {

    private static final int CAR_FORWARD_NUMBER = 4;
    
    private String carName;
    private int position;

    public Car(String name) {
        this.carName = name;
        position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int number) {
        if (number >= CAR_FORWARD_NUMBER) {
            position++;
        }
    }
}
