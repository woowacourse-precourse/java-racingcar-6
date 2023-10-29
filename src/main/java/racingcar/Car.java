package racingcar;

public class Car {
    private String name;
    private int state;

    public Car(String name) {
        Validator.nameLengthCheck(name);
        this.name = name;
        this.state = 0;
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
}
