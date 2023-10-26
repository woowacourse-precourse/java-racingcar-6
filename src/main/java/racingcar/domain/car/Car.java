package racingcar.domain.car;

public class Car {

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
