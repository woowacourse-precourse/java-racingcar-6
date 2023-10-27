package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Car {
    private static final int RANDOM_NUMBER_RANGE_START = 0;
    private static final int RANDOM_NUMBER_RANGE_END = 9;
    private static final int MIN_MOVEMENT_THRESHOLD = 4;

    private static final String CAR_MARK = "-";
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int n = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
        position += Boolean.compare(n >= MIN_MOVEMENT_THRESHOLD, Boolean.TRUE) + 1;
    }

    public String getCarTrail() {
        return name + " : " + CAR_MARK.repeat(position);
    }
}
