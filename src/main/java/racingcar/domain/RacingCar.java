package racingcar.domain;

public class RacingCar {
    private String name;

    private int forward;

    public RacingCar(String name) {
        this.name = name;
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
        this.forward += forward;
    }
}
