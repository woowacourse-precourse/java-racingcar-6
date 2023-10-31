package racingcar;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void move() {
        location++;
    }

    public void tryMove(int fuel) {
        if (canMove(fuel)) {
            move();
        }
    }

    private boolean canMove(int fuel) {
        return fuel >= 4;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
