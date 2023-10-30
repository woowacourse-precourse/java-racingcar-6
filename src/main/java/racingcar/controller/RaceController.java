package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;

import java.util.List;
import java.util.Map;
import racingcar.model.Match;

public class RaceController {
    public static void run() {
        String[] matchInfo = inputMatchesInfo();
        Match match = new Match(matchInfo[0], matchInfo[1]);
        List<Map<String, Integer>> allMatchesResult = match.getAllMatchesResult();


    }

    public static String[] inputMatchesInfo() {
        String carListString = askCarList();
        String numOfMatchesString = askNumOfMatches();
        return new String[]{carListString, numOfMatchesString};
    }

}
