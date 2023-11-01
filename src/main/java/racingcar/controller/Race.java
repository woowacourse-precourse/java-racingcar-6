package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.domain.MoveCount;
import racingcar.util.RacingGuideMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {

    private final InputView inputView;
    private final OutputView outputView;

    public Race() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        CarGroup carGroup = setupCarGroup();
        MoveCount moveCount = setupMoveCount();

        runRace(carGroup, moveCount);
    }

    private void runRace(CarGroup carGroup, MoveCount moveCount) {
        outputView.seperateLine();
        outputView.showMessage(RacingGuideMessage.RACE_RESULT);
        for (int i = 0; i < moveCount.intValue(); i++) {
            carGroup.run();
            outputView.renderRaceStatus(carGroup);
            outputView.seperateLine();
        }
        outputView.showWinners(carGroup.getWinners());
    }

    private CarGroup setupCarGroup() {
        String carNames = inputWithMessage(RacingGuideMessage.INPUT_CAR_NAMES);
        return CarGroup.createNewCarGroupByNames(carNames);
    }

    private MoveCount setupMoveCount() {
        String moveCount = inputWithMessage(RacingGuideMessage.INPUT_MOVE_COUNT);
        return MoveCount.valueOf(moveCount);
    }

    private String inputWithMessage(RacingGuideMessage message) {
        outputView.showMessage(message);
        return inputView.getUserInput();
    }
}
