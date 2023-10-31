package racingcar.domain;

public class RacingCar {

    private final String name;
    private int distance;
    private final static int CAR_NAME_MAX_LENGTH = 5;

    public RacingCar(String name) {
        checkCarNameValidity(name);
        this.name = name;
        distance = 0;
    }

    private void checkCarNameValidity(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
