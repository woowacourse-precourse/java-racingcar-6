package racingcar.controller;

import static racingcar.view.InputView.readCarName;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.NameParser;

public class RacingController {
    private NameParser nameParser = new NameParser();
    private Car car;

    public void start() {
        List<String> carList = nameParser.parseCarName(readCarName());
        nameParser.carNameLengthUnderFive(carList);

         nameParser.setCar(carList);
    }
}
