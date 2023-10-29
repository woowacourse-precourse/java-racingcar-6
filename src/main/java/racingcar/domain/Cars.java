package racingcar.domain;

import static racingcar.contants.RacingGameConstants.RANDOM_MAX_VALUE;
import static racingcar.contants.RacingGameConstants.RANDOM_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.contants.RacingGameConstants;

public class Cars {
    private List<Car> cars;

    public Cars() {
    }

    public Cars(String cars) {
        this.cars = Arrays.stream(cars.split(RacingGameConstants.DELIMITER))
                .map(inputCarName -> new Car(inputCarName))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.moveAccordingToInput(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)));
    }

    public Integer getMaxMovingCount(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public List<String> getWinners(List<Car> cars) {
        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.getMovingCount() == getMaxMovingCount(cars))
                .map(car -> car.getName())
                .collect(Collectors.toList()));
    }
}
