package racingcar.controller;

import racingcar.domain.*;
import racingcar.exception.CarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.RoundCount;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Judgement judgement;

    public RacingController(InputView inputView, OutputView outputView, Judgement judgement) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judgement = judgement;
    }

    public void run() {
        String carNamesFromUser = requestCarNamesFromUser();
        validateCarNames(carNamesFromUser);
        List<String> totalCarNamesList = Parser.parseCarNames(carNamesFromUser);
        Racing racing = new Racing(totalCarNamesList);

        String racingRoundCountFromUser = requestRacingRoundCountFromUser();
        RoundCount roundCount = new RoundCount(racingRoundCountFromUser);

        outputView.displayExecutionResult();
        runRace(roundCount, racing);
        outputView.displayFinalWinners(judgement.determineWinners(racing));
    }

    private String requestCarNamesFromUser() {
        outputView.displayRequestCarNames();
        return inputView.requestCarNameFromUser();
    }

    private String requestRacingRoundCountFromUser() {
        outputView.displayRequestRaceCount();
        return inputView.requestRacingRoundCountFromUser();
    }

    private static void validateCarNames(String carNamesFromUser) {
        CarValidator.validate(carNamesFromUser);
    }

    private void runRace(RoundCount roundCount, Racing racing) {
        for (int round = 0; round < roundCount.getCount(); round++) {
            racing.runOneRound();
            String racingState = racing.displayRaceState();
            outputView.displayRacingState(racingState);
        }
    }
}
