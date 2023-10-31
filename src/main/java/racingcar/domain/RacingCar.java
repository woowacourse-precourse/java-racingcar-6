package racingcar.domain;

public class RacingCar {
    private String name;
    private int distance = 0;

    // 이름을 가지지 않은 자동차 방지
    private RacingCar() {}

    private RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public void move() {
        distance++;
    }
}
