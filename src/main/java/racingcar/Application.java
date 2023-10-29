package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.domain.car.RaceCars;
import racingcar.controller.dto.RaceGameInfo;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGameController raceGameController = new RaceGameController();
        RaceGameInfo raceGameInfo = raceGameController.startRaceGame();
        RaceCars raceCars = raceGameController.run(raceGameInfo);
        raceGameController.printWinningCarNames(raceCars);
    }

}
