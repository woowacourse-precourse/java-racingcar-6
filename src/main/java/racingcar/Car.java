package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    // 기능 3) 자동차의 이름이 유효한지 검증한다.
    private void validateName(String name) {
        if(name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    // 기능 8) 자동차의 이동 거리를 1만큼 증가시킨다.
    public void move() {
        this.distance++;
    }
}
