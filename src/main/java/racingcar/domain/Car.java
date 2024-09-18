package racingcar.domain;

public class Car {
    //무엇을 할 것인가, 핵심 기능 로직
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
