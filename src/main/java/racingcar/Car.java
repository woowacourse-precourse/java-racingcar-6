package racingcar;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        this.name = name;
    }

    private void move() {
        location++;
    }

    public void moveOrStop(int fuel) {
        if (fuel >= 4) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
