package racingcar;

public class Car {
    public static final int INIT_STATE = 0;
    private String name;
    private int state;

    public Car(String name) {
        Validator.nameLengthCheck(name);
        this.name = name;
        this.state = INIT_STATE;
    }

    public void move() {
        this.state++;
    }

    public String currentStatus() {
        return this.name +
                " : " +
                "-".repeat(this.state);
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
