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

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }

    public void playRound() {
        cars.forEach(Car::move);
    }


    public RoundResponses buildRoundResponse() {
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

    private Integer getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(() -> RacingCarException.of(SYSTEM_ERROR));
    }
}
