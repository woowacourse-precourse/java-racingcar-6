package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.ValidationService;
import racingcar.model.Driver;

import java.util.List;

public class Game {

    private ValidationService validationService;

    public Game() {
        this.validationService = new ValidationService();
    }

    public void start() {
        String driverInputString = Console.readLine();
        List<Driver> driverList = validationService.inputToDriverList(driverInputString);

    }
}
