package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Participant;
import racingcar.domain.RacingResult;
import racingcar.view.IOMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final static Integer END_GAME = 0;

    public void runGame() {
        List<String> playerList = InputView.askRegistry();
        Participant participant = Participant.from(playerList);
        Integer playTime = InputView.askPlayTime();
        Console.close();

        playTilEndGame(participant, playTime);
        announceWinner(participant);
    }

    private static void playTilEndGame(Participant participant, int playTime) {
        OutputView.printMessage(IOMessage.EXECUTION_RESULT);
        do {
            participant.tryProgress();
            RacingResult result = participant.generateResult();
            OutputView.printExecutionResult(result.referExecution());
        } while (--playTime != END_GAME);
    }

    private static void announceWinner(Participant participant) {
        RacingResult result = participant.generateResult();
        OutputView.printWinner(result.referWinner());
    }
}


