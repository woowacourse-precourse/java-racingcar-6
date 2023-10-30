package racingcar.controller;

import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingGame racingGame = initializeGame();
        repeatPlayRace(racingGame);
    }

    private RacingGame initializeGame() {
        CarNameDto carNameDto = inputView.readCarName();
        Cars cars = Cars.from(carNameDto.getCarNameList());

        RaceCountDto raceCountDto = inputView.readRaceCount();
        int raceCount = raceCountDto.getCnt();

        return RacingGame.init(cars, raceCount);
    }

    private void repeatPlayRace(RacingGame racingGame) {
        for (int i = 1; i <= racingGame.getRaceCount(); i++) {
            racingGame.playRaceGame();
        }
    }
}
