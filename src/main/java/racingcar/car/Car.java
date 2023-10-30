package racingcar.car;

import racingcar.Validator;

public class Car {

    private final String name;

    private int position;


    public Car(String name, int nameMaxLength) {
        checkNameLength(name, nameMaxLength);
        this.name = name;
        this.position = 0;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    public boolean isInPosition(int position) {
        return this.position == position;
    }

    private void checkNameLength(String name, int nameMaxLength) {
        Validator.limitStringLength(name, nameMaxLength);
    }

}
