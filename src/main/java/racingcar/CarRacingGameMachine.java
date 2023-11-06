package racingcar;

import java.util.List;
import racingcar.model.CarFactory;
import racingcar.model.Winners;
import racingcar.model.movingstrategy.RacingCarMovingStrategy;
import racingcar.model.RacingCars;
import racingcar.model.movingstrategy.RandomRacingCarMovingStrategy;
import racingcar.util.NamesInputConverter;
import racingcar.util.NumberInputConverter;
import racingcar.view.InputView;
import racingcar.view.ScoreBoard;

public class CarRacingGameMachine {

    private final static int CAR_NAME_LENGTH_LIMIT = 5;

    public void start() {
        RacingCars racingCars = getRacingCars();
        int gameCount = NumberInputConverter.convert(InputView.requestPlayCountInput());

        race(racingCars, gameCount);
    }

    private RacingCars getRacingCars() {
        List<String> carNames = getCarNames();
        return getRandomMovingStrategyCars(carNames);
    }

    private List<String> getCarNames() {
        String carNamesInput = InputView.requestCarNamesInput();
        return NamesInputConverter.convertToNames(carNamesInput)
            .stream()
            .peek(this::validateNamesEqualOrLessThanLengthLimit)
            .toList();
    }

    private void validateNamesEqualOrLessThanLengthLimit(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private RacingCars getRandomMovingStrategyCars(List<String> carNames) {
        RacingCarMovingStrategy randomRacingCarMovingStrategy = new RandomRacingCarMovingStrategy();
        CarFactory carFactory = CarFactory.createCarFactoryWithMovingStrategy(
            randomRacingCarMovingStrategy);
        return carFactory.createRacingCarsByNames(carNames);
    }


    private void race(RacingCars racingCars, int gameCount) {
        ScoreBoard.displayGameProgressMessage();
        while (gameCount-- > 0) {
            racingCars.race();
            racingCars.printCarsPosition();
        }

        displayWinners(racingCars);
    }

    private void displayWinners(RacingCars racingCars) {
        Winners winners = racingCars.getWinners();
        ScoreBoard.displayWinners(winners.winners());
    }
}
