package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;

import racingcar.model.Match;

public class RaceController {
    public static void run() {
        String[] matchInfo = inputMatchInfo();
        Match match = new Match(matchInfo[0], matchInfo[1]);

    }

    public static String[] inputMatchInfo() {
        String carListString = askCarList();
        String numOfMatches = askNumOfMatches();
        return new String[]{carListString, numOfMatches};
    }

}
