package racingcar.gamefield;

import static racingcar.system.SystemConstant.*;

import java.util.List;
import racingcar.assist.NumberComparator;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingStadium {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberComparator numberComparator;
    private final DisplayBoard displayBoard;
    private final CarFactory carFactory;


    public RacingStadium() {
        inputView = new InputView();
        outputView = new OutputView();
        numberComparator = new NumberComparator();
        displayBoard = new DisplayBoard();
        carFactory = new CarFactory();
    }

    public void run() {
        List<String> carNameList = inputView.requestCarNamesInput();
        List<Car> carList = carFactory.generateCarListWithName(carNameList);
        displayBoard.initCarPosition(carNameList);
        startRacing(carList);
        outputView.responseRaceWinner(displayBoard);
    }

    private void startRacing(List<Car> carList) {
        int repeatTimes = inputView.requestRepeatTimesInput();
        outputView.responseRaceResultMessage();
        for (int i = 0; i < repeatTimes; i++) {
            tryEachCarGoForward(carList);
            outputView.responseRacingResult(displayBoard);
        }
    }

    private void tryEachCarGoForward(List<Car> carList) {
        for (Car car : carList) {
            tryGoForward(car);
        }
    }

    private void tryGoForward(Car car) {
        if (numberComparator.isNumberOverWinNumber()) {
            car.goForward();
            displayBoard.updateCurrentCarPosition(car);
        }
    }
}
