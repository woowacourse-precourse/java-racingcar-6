package racingcar.controller;

import java.util.List;
import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.dto.response.CarWinnersDto;
import racingcar.dto.response.RaceHistoryDto;
import racingcar.model.CarGroup;
import racingcar.model.CarWinners;
import racingcar.model.MovementCondition;
import racingcar.model.RaceHistory;
import racingcar.model.RacingGame;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementCondition movementCondition;

    public RacingGameController(InputView inputView, OutputView outputView, MovementCondition movementCondition) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementCondition = movementCondition;
    }

    public void run() {
        RacingGame racingGame = createRacingGame();
        RaceHistory raceHistory = play(racingGame);
        printGameResultFrom(raceHistory);
        printWinnersFrom(raceHistory);
    }

    private RacingGame createRacingGame() {
        CarGroup carGroup = createCarGroup();
        TryCount tryCount = createTryCount();
        return RacingGame.of(carGroup, tryCount);
    }

    private CarGroup createCarGroup() {
        RacingCarNamesDto racingCarNamesDto = inputView.readRacingCarNames();
        List<String> carNames = racingCarNamesDto.getCarNames();
        return CarGroup.from(carNames);
    }

    private TryCount createTryCount() {
        TryCountDto tryCountDto = inputView.readTryCount();
        int tryCount = tryCountDto.getTryCount();
        return TryCount.from(tryCount);
    }

    private RaceHistory play(RacingGame racingGame) {
        return racingGame.startRaceWith(movementCondition);
    }

    private void printGameResultFrom(RaceHistory raceHistory) {
        RaceHistoryDto raceHistoryDto = RaceHistoryDto.from(raceHistory);
        outputView.printRaceHistory(raceHistoryDto);
    }

    private void printWinnersFrom(RaceHistory raceHistory) {
        CarWinners winners = raceHistory.findFinalStageWinners();
        printWinners(winners);
    }

    private void printWinners(CarWinners winners) {
        CarWinnersDto carWinnersDto = CarWinnersDto.from(winners);
        outputView.printWinners(carWinnersDto);
    }
}
