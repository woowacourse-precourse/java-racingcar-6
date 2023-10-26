package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward() {
        this.position++;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
