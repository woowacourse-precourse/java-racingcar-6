package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String carName) {
        this.name = carName;
        this.position = 0;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
