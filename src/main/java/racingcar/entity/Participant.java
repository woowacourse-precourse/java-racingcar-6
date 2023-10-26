package racingcar.entity;

import java.util.Comparator;

public class Participant {
    private String name;

    private int forward;

    public Participant(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

}
