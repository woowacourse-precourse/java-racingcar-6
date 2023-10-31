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

    public String carInfo() {
        String output = "";
        output += name + Texts.SPACE + Texts.COLON + Texts.SPACE;
        for (int i = 0; i < count; i++) {
            output += Texts.BAR;
        }
        return output;
    }
}
