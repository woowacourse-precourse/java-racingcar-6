package racingcar.model.car;

import racingcar.constants.Texts;

public class Car {
    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        count = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
