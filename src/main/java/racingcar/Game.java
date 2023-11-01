package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.DriverService;
import racingcar.service.ValidationService;
import racingcar.model.Driver;

import java.util.List;

public class Game {

    private ValidationService validationService;
    private DriverService driverService;

    public Game() {
        this.validationService = new ValidationService();
        this.driverService = new DriverService();
    }

    public void start() {
        List<Driver> driverList = inputDriverList();
        int tryCount = inputTryCount();

        for (int i = 0; i < tryCount; i++) {
            play(driverList);
        }

        List<String> winnerList = driverService.getWinnerList(driverList);

    }

    private int inputTryCount() {
        String tryCountInputString = Console.readLine();
        int tryCount = validationService.inputToTryCount(tryCountInputString);
        return tryCount;
    }

    private List<Driver> inputDriverList() {
        String driverInputString = Console.readLine();
        List<Driver> driverList = validationService.inputToDriverList(driverInputString);
        return driverList;
    }

    private void play(List<Driver> driverList) {
        for (Driver driver : driverList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            driverService.move(randomNumber, driver);
        }
    }
}
