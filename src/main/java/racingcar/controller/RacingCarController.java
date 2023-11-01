package racingcar.controller;

import java.util.Iterator;
import racingcar.model.RacingCarModel;
import racingcar.view.RacingCarView;

public class RacingCarController {
    RacingCarView view;
    RacingCarModel model;

    public RacingCarController(RacingCarView view) {
        this.view = view;
    }

    public void play() {
        view.displayCarNameSetupMessage();
        setupModel();

        view.displayRoundCountSetupMessage();
        int roundCount = getRoundCount();

        while (roundCount != 0) {
            model.attemptMove();
            Iterator<String> roundResultIterator = model.getRoundResultIterator();
            view.displayRoundResults(roundResultIterator);

            roundCount--;
        }

        Iterator<String> winnerListIterator = model.getWinnerListIterator();
        view.displayWinnerList(winnerListIterator);
    }

    private void setupModel() {
        UserInputHandler<Iterator<String>> carNameHandler = new CarNameHandler();
        String rawCarNames = view.getUserInput();
        carNameHandler.handle(rawCarNames);
        Iterator<String> carNameListIterator = carNameHandler.getHandledResult();
        model = new RacingCarModel(carNameListIterator);
    }

    private int getRoundCount() {
        UserInputHandler<Integer> roundCountHandler = new RoundCountHandler();
        String stringRoundCount = view.getUserInput();
        roundCountHandler.handle(stringRoundCount);
        return roundCountHandler.getHandledResult();
    }
}
