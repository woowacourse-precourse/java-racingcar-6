package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;

import racingcar.model.Match;

public class Race {
    public static void updateMatchInfo() {
        String carListString = askCarList();
        String numOfMatches = askNumOfMatches();
        Match match = new Match(carListString, numOfMatches);
    }

}
