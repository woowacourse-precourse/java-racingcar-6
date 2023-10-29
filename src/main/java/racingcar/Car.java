package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void move() {
        position += 1;
    }

    private void stay() {
        // 아무것도 하지않음
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

}
