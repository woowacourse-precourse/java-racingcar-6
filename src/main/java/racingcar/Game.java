package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.DriverService;
import racingcar.service.ValidationService;
import racingcar.model.Driver;
import racingcar.view.GameView;

import java.util.List;

public class Game {

    private ValidationService validationService;
    private DriverService driverService;
    private GameView gameView;

    public Game() {
        this.validationService = new ValidationService();
        this.driverService = new DriverService();
        this.gameView = new GameView();
    }

    public void start() {
        List<Driver> driverList = inputDriverList();
        int tryCount = inputTryCount();

        gameView.gameResultView();
        for (int i = 0; i < tryCount; i++) {
            play(driverList);
           gameView.playProgressView(driverList);
        }
        List<String> winnerList = driverService.getWinnerList(driverList);
    }


    private int inputTryCount() {
        gameView.tryCountInputView();
        String tryCountInputString = Console.readLine();
        int tryCount = validationService.inputToTryCount(tryCountInputString);
        return tryCount;
    }

    private List<Driver> inputDriverList() {
        gameView.driverListInputView();
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
