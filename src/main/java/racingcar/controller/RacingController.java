package racingcar.controller;

import static racingcar.view.InputView.readCarName;

import java.util.List;
import racingcar.model.NameParser;

public class RacingController {
    private final NameParser nameParser = new NameParser();

    public void start() {
        List<String> carList = nameParser.parseCarName(readCarName());
        nameParser.setCar(carList);
    }
}
