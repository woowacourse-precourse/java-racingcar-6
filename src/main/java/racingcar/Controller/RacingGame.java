package racingcar.Controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.util.AttemptCount;
import racingcar.util.RandomMoving;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.view.InputView.setAttempt;
import static racingcar.view.InputView.setCarNames;
import static racingcar.view.OutputView.printLine;
import static racingcar.view.OutputView.printWinners;

public class RacingGame {
    private Cars cars;
    private AttemptCount gameAttemptCount;
    private RandomMoving movingStrategy = new RandomMoving();

    public void start() throws IllegalArgumentException {
        initRacingCarGame();

        while (gameAttemptCount.isContinue()) {
            gameAttemptCount.reduceAttemptCount();
            run();
        }

        List<String> winnerNameList = getWinners();
        printWinners(winnerNameList);
    }

    private void initRacingCarGame() throws IllegalArgumentException {
        List<String> carNames = setCarNames();
        cars = new Cars(carNames);

        String attempt = setAttempt();
        gameAttemptCount = new AttemptCount(attempt);
    }

    private void run() {
        cars.progressWithAllCar(movingStrategy);
        printProgress();
        printLine();
    }

    private void printProgress() {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);

            OutputView.printProgress(CarDto.of(car));
        }
    }

    private List<String> getWinners() {
        int maxPosition = cars.getMaxPosition();

        return cars.getWinner(maxPosition);
    }
}
