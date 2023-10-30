package racingcar;

import java.util.Iterator;

public class RacingCarController {
    RacingCarView view;
    RacingCarModel model;

    public RacingCarController(RacingCarView view){
        this.view = view;
    }

    public void play(){
        view.displayCarNameSetupMessage();

        UserInputHandler<Iterator<String>> carNameHandler = new CarNameHandler();
        String rawCarNames = view.getUserInput();
        carNameHandler.handle(rawCarNames);
        Iterator<String> carNameListIterator = carNameHandler.getHandledResult();
        model = new RacingCarModel(carNameListIterator);


        UserInputHandler<Integer> roundCountHandler = new RoundCountHandler();
        view.displayRoundCountSetupMessage();
        String stringRoundCount = view.getUserInput();
        roundCountHandler.handle(stringRoundCount);

        int roundCount = roundCountHandler.getHandledResult();

        while (roundCount != 0){
            model.takeStep();
            Iterator<String> roundResultIterator = model.getRoundResultIterator();
            view.displayRoundResults(roundResultIterator);

            roundCount--;
        }

        Iterator<String> winnerListIterator = model.getWinnerListIterator();
        view.displayWinnerList(winnerListIterator);
    }


}
