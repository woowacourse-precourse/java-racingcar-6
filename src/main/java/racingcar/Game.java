package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.MoveService;
import racingcar.validation.ValidationService;
import racingcar.model.Driver;

import java.util.List;

public class Game {

    private ValidationService validationService;
    private MoveService moveService;

    public Game() {
        this.validationService = new ValidationService();
        this.moveService = new MoveService();
    }

    public void start() {
        String driverInputString = Console.readLine();
        List<Driver> driverList = validationService.inputToDriverList(driverInputString);

        String tryCountInputString = Console.readLine();
        int tryCount = validationService.inputToTryCount(tryCountInputString);

        for (int i = 0; i < tryCount; i++) {
            play(driverList);
        }
    }

    private void play(List<Driver> driverList) {
        for (Driver driver : driverList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            moveService.move(randomNumber, driver);
        }
    }
}
