package racingcar.controller;

import static racingcar.common.Constant.RAND_NUM_MAX_RANGE;
import static racingcar.common.Constant.RAND_NUM_MIN_RANGE;

import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.controller.dto.response.GameResultDto;
import racingcar.controller.dto.response.RaceResultDto;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.RacingGame;
import racingcar.model.RandomSingleNumber;
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
        GameResult gameResult = inGame(racingGame);
        afterGame(gameResult);
    }

    private GameResult inGame(RacingGame racingGame) {
        repeatPlayGame(racingGame);

        return racingGame.getGameResult();
    }

    private RacingGame initializeGame() {
        CarNameDto carNameDto = inputView.readCarName();
        Cars cars = Cars.from(carNameDto.carNameList());

        RaceCountDto raceCountDto = inputView.readRaceCount();
        int raceCount = raceCountDto.cnt();

        return RacingGame.init(cars, raceCount);
    }

    private void repeatPlayGame(RacingGame racingGame) {
        outputView.printExecutionResultMessage();

        for (int round = 1; round <= racingGame.getRaceCount(); round++) {
            RandomSingleNumber number = RandomSingleNumber.of(RAND_NUM_MIN_RANGE, RAND_NUM_MAX_RANGE);
            racingGame.playGame(number);

            outputView.printRaceResult(new RaceResultDto(racingGame.getCarList()));
        }
    }

    private void afterGame(GameResult gameResult) {
        outputView.printGameResult(new GameResultDto(gameResult.getWinnerCarsNameList()));
    }
}
