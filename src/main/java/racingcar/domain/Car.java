package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public String getName() {
        return name;
    }
    public void setName(String carName) {
        this.name = carName;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
