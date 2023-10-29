package racingcar.domain;

public class RacingCar {
    private String name;

    // 이름을 가지지 않은 자동차 방지
    private RacingCar() {}

    private RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }
}
