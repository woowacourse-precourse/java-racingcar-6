package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.domain.car.RaceCars;
import racingcar.dto.RaceGameInfoDto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGameController raceGameController = new RaceGameController();
        RaceGameInfoDto raceGameInfoDto = raceGameController.startRaceGame();
        RaceCars raceCars = raceGameController.run(raceGameInfoDto);
        raceGameController.printWinningCarNames(raceCars);
    }

}
