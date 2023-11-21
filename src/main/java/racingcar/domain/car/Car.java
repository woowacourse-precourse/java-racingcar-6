package racingcar.domain.car;

import racingcar.domain.numbergenerator.MoveNumber;

public class Car {
    public static final int INIT_POSITION = 0;
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = INIT_POSITION;
    }

    public boolean move(MoveNumber number) {
        if (number.canMove()) {
            this.position++;
            return true;
        }
        return false;
    }


    public boolean at(int position) {
        return this.position == position;
    }


    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
