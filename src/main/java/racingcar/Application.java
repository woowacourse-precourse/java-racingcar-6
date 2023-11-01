package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.dto.RaceGameInfoDto;
import racingcar.dto.WinnerCarDto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGameController raceGameController = new RaceGameController();
        RaceGameInfoDto raceGameInfoDto = raceGameController.startRaceGame();
        WinnerCarDto winnerCarDTO = raceGameController.run(raceGameInfoDto);
        raceGameController.printWinningCarNames(winnerCarDTO);
    }

}
