package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MoveResultDto;

public class Car {

    private static final int START_LOCATION = 0;
    private static final int MOVE_FORWARD_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String name;
    private Integer location;

    private Car(String name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    public static Car withName(String name) {
        return new Car(name);
    }

    public MoveResultDto move() {
        moveOrStop(generateRandomNumber());
        return MoveResultDto.make(name, location);
    }

//    public static List<Car> create(CarNames carNames) {
//        return carNames.stream()
//                .map(CarNames::createCar)
//                .toList();
//    }

    private static Car createCar(String carName) {
        return Car.withName(carName);
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    protected void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_NUMBER) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
