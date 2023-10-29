package racingcar.controller;

import static racingcar.view.InputView.readCarName;

import java.util.List;
import racingcar.model.NameParser;
import racingcar.view.InputView;

public class RacingController {
    private final NameParser nameParser = new NameParser();

    public void start() {
        List<String> list = nameParser.parseName(readCarName());
        for(String car: list) {
            System.out.println(car);
        }

    }
}
