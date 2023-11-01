package racingcar;

import static racingcar.Constants.*;

public class Car {
    private String name;
    private String forward;

    public Car(String name) {
        this.name = name;
        this.forward = EMPTY_STRING;
    }

    public String getName() {
        return this.name;
    }

    public String getForward() {
        return this.forward;
    }

    public Integer getForwardNumber() {
        return this.forward.length();
    }

    public void addForward() {
        this.forward += FORWARD_SIGH;
    }

}
