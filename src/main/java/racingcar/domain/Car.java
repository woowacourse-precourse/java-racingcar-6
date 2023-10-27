package racingcar.domain;

public class Car {
    private String name;
    private int move;

    private Car() {

    }

    public Car(String name, int move) {
        if (!nameLengthCheck(name)) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5를 초과할 수 없습니다.");
        }
        this.name = name;
        this.move = move;
    }

    public void Forward() {
        this.move++;
    }

    public int currentLocation() {
        return this.move;
    }

    public boolean nameLengthCheck(String name) {
        return name.length() <= 5;
    }
}
