package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingPlayer;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingService racingService = new RacingService();

    public void runGame() {
        String racer = inputView.inputCarNames();
        List<String> racersList = racingService.racerNameStringToList(racer);
        racingService.validateNames(racersList);

        List<RacingPlayer> playersList = racingService.storeRacerNames(racersList);

        String countInput = inputView.inputAttemptCount();
        racingService.validateCount(countInput);

        int count = racingService.countStringToInt(countInput);

        System.out.println();
        conductRace(playersList, count);
    }

    public void conductRace(List<RacingPlayer> playersList, int count) {
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            racingService.updateScoreIfNecessary(playersList);
            outputView.outputRaceProgress(playersList);
        }

        String winner = racingService.checkFinalScores(playersList);

        outputView.outputWinners(winner);
    }
}
