package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.constant.StringConstants;
import racingcar.game.converter.CarConverter;
import racingcar.game.domain.Car;
import racingcar.io.Input;
import racingcar.io.Output;

public class RacingCarGame implements Game {
    private int tryCount;
    private List<Car> cars;

    @Override
    public boolean beforeLoop() {
        final var carsInput = Input.promptLine(StringConstants.PLAYER_PROMPT_MESSAGE);
        final var cars = CarConverter.inputToListOfCars(carsInput);

        final var tryCountInput = Input.promptLine(StringConstants.TRY_COUNT_PROMPT_MESSAGE);
        final var tryCount = CarConverter.inputToTryCount(tryCountInput);

        this.cars = cars;
        this.tryCount = tryCount;
        return true;
    }

    @Override
    public boolean gameLoop() {
        System.out.println(StringConstants.GAME_RESULT_MESSAGE);
        for (int t = 0; t < tryCount; t++) {
            for (var car : cars) {
                car.go();
                Output.println(car);
            }
            Output.println("");
        }
        return false;
    }

    @Override
    public boolean afterLoop() {
        final Car max = cars.stream()
                .max(Car::compareMileage)
                .orElseThrow(IllegalArgumentException::new);

        final List<String> winners = cars.stream()
                .filter(c -> c.compareMileage(max) == 0).map(c -> c.getName())
                .collect(Collectors.toList());

        final String message = String.join(", ", winners);
        Output.print(StringConstants.FINAL_WINNER_MESSAGE + " : " + message);
        return false;
    }
}
