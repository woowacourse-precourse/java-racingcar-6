package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.ConstantString.LINE;

public class Racing {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final String COLON_SEPARATOR = " : ";
    private static final String HYPHEN = "-";

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runOneRound() {
        for (Car car : cars) {
            int randomValue = NumberGenerator.generateRandomNumber();
            if (randomValue >= MIN_FORWARD_THRESHOLD) {
                car.forward();
            }
        }
    }

    public String displayRaceState() {
        List<String> raceStateList = new ArrayList<>();
        for (Car car : cars) {
            String carInfo = car.getName() + COLON_SEPARATOR;
            String hyphenCount = generateHyphens(car.getForwardCount());
            raceStateList.add(carInfo + hyphenCount);
        }
        return String.join(LINE, raceStateList);
    }

    private String generateHyphens(int forwardCount) {
        if (forwardCount <= 0) return "";
        return HYPHEN.repeat(forwardCount);
    }
}
