package racingcar.controller;

import static racingcar.view.InputView.readMovingCount;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.GoStopDecider;
import racingcar.model.NameParser;
import racingcar.model.WinnerDecider;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final NameParser nameParser = new NameParser();
    private final GoStopDecider goStopDecider = new GoStopDecider();
    private final WinnerDecider winnerDecider = new WinnerDecider();


    public void start() {
        List<Car> carList = makeCarList(readCarName());
        int movingCount = readMovingCount();

        OutputView.printGameResult();

        printAllRacingResult(movingCount, carList);

        OutputView.printWinner();
        List<String> winnerNameList = winnerDecider.getWinners(carList);
        OutputView.printWinnerName(winnerNameList);
    }

    public List<String> readCarName() {
        return nameParser.parseCarName(InputView.readCarName());
    }

    public List<Car> makeCarList(List<String> carNameList) {
        nameParser.carNameLengthUnderFive(carNameList);
        return nameParser.setCar(carNameList);
    }

    public void printAllRacingResult(int movingCount, List<Car> carList) {
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

    public void printOneCarResult(Car car) {
        OutputView.printOneCarResult(car.getName(), car.getDistance());
    }
}
