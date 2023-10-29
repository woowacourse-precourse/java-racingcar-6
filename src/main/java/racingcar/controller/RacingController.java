package racingcar.controller;

import static racingcar.view.InputView.readCarName;
import static racingcar.view.InputView.readMovingCount;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.GoStopDecider;
import racingcar.model.NameParser;

public class RacingController {
    private final NameParser nameParser = new NameParser();
    private final GoStopDecider goStopDecider = new GoStopDecider();
    private Car car;

    public void start() {
        List<String> carNmaeList = nameParser.parseCarName(readCarName());
        nameParser.carNameLengthUnderFive(carNmaeList);

         List<Car> carList = nameParser.setCar(carNmaeList);

         int movingCount = readMovingCount();

         for (Car car : carList) {
            goStopDecider.numbersOfMovement(car);
        }


    }
}
