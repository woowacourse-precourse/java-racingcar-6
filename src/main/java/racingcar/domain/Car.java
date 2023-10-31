package racingcar.domain;

import racingcar.validation.CarNameValidator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name){
        CarNameValidator.checkValidLength(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public boolean isPositionEqual(int position) {
        return this.position == position;
    }

    public boolean isPositionFurther(Car anotherCar) {
        return this.position >= anotherCar.position;
    }

    public String getProgress() {
        return "-".repeat(position);
    }

    public String getCarStatus() {
        return name + " : " + getProgress();
    }

    public String getName(){
        return name;
    }
}
