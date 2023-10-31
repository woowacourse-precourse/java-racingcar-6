package racingcar;

import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final CarList carList = new CarList();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        String[] carNamesArray = inputView.getCarNames();
        carList.addCars(carNamesArray);

        int attempt = inputView.getAttemptNumber();

        outputView.printResult();
        repeatCarMovement(attempt);

        Winners winners = carList.getWinners();
        outputView.printWinners(winners.getWinningCarNames());
    }

    private void performCarMovements() {
        carList.moveAllCars();
        for (Car car : carList.getCarList()) {
            outputView.printNameAndDistance(car.getName(), car.getDistance());
        }
        outputView.printNewLine();
    }

    private void repeatCarMovement(int attempt) {
        IntStream.range(0, attempt)
                .forEach(i -> performCarMovements());
    }
}