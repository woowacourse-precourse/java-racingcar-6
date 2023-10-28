package racingcar.domain;

import racingcar.global.exception.RacingCarException;
import racingcar.utility.Parser;

import java.util.Collections;
import java.util.List;

import static racingcar.global.exception.ErrorMessage.SYSTEM_ERROR;
import static racingcar.utility.ConstraintValidator.*;

public class Cars {
    private final List<Car> racingCars;

    // Car Constructor
    private Cars(final String input) {
        validateNull(input);
        validateContainTab(input);
        validateContainNewLine(input);
        validateContainWhiteSpace(input);
        validateEndsWithComma(input);

        List<String> carNames = Parser.parseCarNames(input);
        validateNameLength(carNames);

        this.racingCars = createCars(carNames);
    }

    // Cars Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    // 경주할 자동차를 1회전 전진시킨다.
    public List<String> playOneRound() {
        racingCars.forEach(Car::play);
        return generateResults();
    }

    // 자동차들의 현재 주행 결과를 '이름 : dashes' 형태의 String List로 반환
    public List<String> generateResults() {
        return racingCars.stream()
                .map(Car::generateResult)
                .toList();
    }

    public WinnerResult makeResult() {
        List<Car> cars = Collections.unmodifiableList(racingCars);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSameScore(getMaxScore()))
                .toList();
        return WinnerResult.create(winners);
    }

    public Integer getMaxScore() {
        return racingCars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(() -> RacingCarException.of(SYSTEM_ERROR));
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }
}
