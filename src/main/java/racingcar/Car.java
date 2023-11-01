package racingcar;

import static racingcar.Validation.*;

public class Car {
    public String name;
    public int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;

        checkMaxNameLength(this.name);
        checkNameIsEmpty(this.name);
    }

}
