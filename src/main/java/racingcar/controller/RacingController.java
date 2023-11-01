package racingcar.controller;

import static racingcar.view.InputView.readMovingCount;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.GoStopDecider;
import racingcar.util.CarNameParser;
import racingcar.util.WinnerDecider;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final CarNameParser carNameParser = new CarNameParser();
    private final GoStopDecider goStopDecider = new GoStopDecider();
    private final WinnerDecider winnerDecider = new WinnerDecider();
    List<String> carNameList;
    List<Car> carList;
    int movingCount;
    public void run() {
        carNameList = readCarName();
        carList = makeCarList(carNameList);
        movingCount = readMovingCount();

        OutputView.printGameResult();

        printAllRacingResult(movingCount, carList);

        OutputView.printWinner();
        List<String> winnerNameList = winnerDecider.getWinners(carList);
        OutputView.printWinnerName(winnerNameList);
    }

    private List<String> readCarName() {
        return carNameParser.parseCarName(InputView.readCarName());
    }

    public List<Car> makeCarList(List<String> carNameList) {
        carNameParser.carNameLengthUnderFive(carNameList);
        return carNameParser.stringToCarName(carNameList);
    }

    private void printAllRacingResult(int movingCount, List<Car> carList) {
        for (int i = 0; i < movingCount; i++) {
            printCarListResult(carList);
        }
    }

    private void printCarListResult(List<Car> carList) {
        for (Car car : carList) {
            goStopDecider.moveCarOnRandomValue(car);
            printOneCarResult(car);
        }
        System.out.println();
    }

    private void printOneCarResult(Car car) {
        OutputView.printOneCarResult(car.getName(), car.getDistance());
    }
}
