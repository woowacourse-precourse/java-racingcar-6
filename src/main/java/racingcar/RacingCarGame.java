package racingcar;

import java.util.stream.IntStream;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final CarList carList;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame() {
        this.carList = new CarList();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

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

        carList.getCarList().forEach(car -> {
            outputView.printNameAndDistance(car.getName(), car.getDistance());
        });

        outputView.printNewLine();
    }

    private void repeatCarMovement(int attempt) {
        IntStream.range(0, attempt)
                .forEach(i -> performCarMovements());
    }
}