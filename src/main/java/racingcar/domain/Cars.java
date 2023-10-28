package racingcar.domain;

import racingcar.exception.RacingCarException;
import racingcar.parser.Parser;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.ErrorMessage.SYSTEM_ERROR;

public class Cars {
    private final List<Car> cars;

    // Car Constructor
    private Cars(final String input) {
        List<String> carNames = Parser.parseCarNames(input);
        this.cars = createCars(carNames);
    }

    // Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    /**
     * Define Create Cars
     */
    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }

    /**
     * Define Play One Round Function
     */
    public void playRound() {
        cars.forEach(Car::move);
    }


    /**
     * Define to return Result
     */
    public List<String> generateRoundResult() {
        return cars.stream()
                .map(Car::generateScoreResponse)
                .toList();
    }

    public String getWinnerNames() {
        return cars.stream()
                .filter(car -> car.isSameScore(getMaxScore()))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private Integer getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(() -> RacingCarException.of(SYSTEM_ERROR));
    }
}
