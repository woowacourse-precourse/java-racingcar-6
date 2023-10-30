package racingcar.controller;

import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.controller.dto.response.RaceResultDto;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = initializeGame();
        repeatPlayRace(racingGame);
    }

    private RacingGame initializeGame() {
        CarNameDto carNameDto = inputView.readCarName();
        Cars cars = Cars.from(carNameDto.carNameList());

        RaceCountDto raceCountDto = inputView.readRaceCount();
        int raceCount = raceCountDto.cnt();

        return RacingGame.init(cars, raceCount);
    }

    private void repeatPlayRace(RacingGame racingGame) {
        outputView.printExecutionResultMessage();

        for (int i = 1; i <= racingGame.getRaceCount(); i++) {
            racingGame.playRaceGame();

            outputView.printRaceResult(new RaceResultDto(racingGame.getCarList()));
        }
    }
}
