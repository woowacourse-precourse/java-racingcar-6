package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;
import static racingcar.view.OutputView.printPerMatchResult;
import static racingcar.view.OutputView.printSystemMessage;
import static racingcar.view.OutputView.printWinner;
import static racingcar.view.SystemMessage.TESTING;

import racingcar.model.Race;

public class RaceController {
    public static void run() {
        Race race = new Race(askCarList(), askNumOfMatches());
        printSystemMessage(TESTING);
        for (int i = 0; i < race.getNumOfMatches(); i++) {
            race.match();
            printPerMatchResult(race.getPerMatchResult());
        }
        printWinner(race.getWinner());
    }
}
