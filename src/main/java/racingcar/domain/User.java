package racingcar.domain;

/**
 * 경주에 참여하는 주체
 */
public class User {
    private String name;
    private RacingCar car;

    private User(String name, RacingCar car) {
        this.name = name;
        this.car = car;
    }

    public static User of(String name, RacingCar car) {
        return new User(name, car);
    }
}
