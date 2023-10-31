package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController();
        InputController inputController = new InputController();

        inputController.enterCarNamesAndCount();
        String carNames = inputController.getCarNames();
        int racingCount = inputController.getRacingCount();
        racingController.settingCars(carNames);
        racingController.playRacing(racingCount);
        racingController.printWinner();
    }
}
