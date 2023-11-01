package racingcar.domain;

import racingcar.dto.FinalResponse;
import racingcar.dto.RoundResponse;
import racingcar.dto.RoundResponses;
import racingcar.exception.RacingCarException;
import racingcar.parser.Parser;

import java.util.List;

import static racingcar.exception.ErrorMessage.SYSTEM_ERROR;

public class Cars {
    private final List<Car> cars;

    private Cars(final String input) {
        List<String> carNames = Parser.parseCarNames(input);
        this.cars = createCars(carNames);
    }

    public static Cars create(final String input) {
        return new Cars(input);
    }

    public void playOneRound() {
        cars.forEach(Car::move);
    }

    public RoundResponses buildRoundResponses() {
        List<RoundResponse> roundResponses = cars.stream()
                .map(Car::generateRoundResponse)
                .toList();
        return new RoundResponses(roundResponses);
    }

    public FinalResponse buildFinalResponse() {
        List<String> winnerNames = cars.stream()
                .filter(car -> car.isSameScore(getMaxScore()))
                .map(Car::getName)
                .toList();
        return new FinalResponse(winnerNames);
    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }

    private Integer getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(() -> RacingCarException.of(SYSTEM_ERROR));
    }
}
