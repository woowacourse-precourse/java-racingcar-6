package racingcar.controller;

import static racingcar.view.InputView.readMovingCount;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.GoStopDecider;
import racingcar.model.NameParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final NameParser nameParser = new NameParser();
    private final GoStopDecider goStopDecider = new GoStopDecider();


    public void start() {
        List<Car> carList = makeCarList(readCarName());

        OutputView.printGameResult();

        printAllRacingResult(readMovingCount(), carList);
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
        System.out.print('\n');
    }

    public void printOneCarResult(Car car) {
        OutputView.printOneCarResult(car.getName(), car.getDistance());
    }
}
