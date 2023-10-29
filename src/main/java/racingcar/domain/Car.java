package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String carName) {
        this.name = carName;
    }
    public String getName() {
        return name;
    }

    public void move() {
        if (RandomNumber.randomNumber()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
