package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;

import java.util.List;
import java.util.Map;
import racingcar.model.Race;

public class RaceController {
    public static void run() {
        String[] matchInfo = inputMatchesInfo();
        Race race = new Race(matchInfo[0], matchInfo[1]);
        List<Map<String, Integer>> allMatchesResult = race.getAllMatchesResult();


    }

    public static String[] inputMatchesInfo() {
        String carListString = askCarList();
        String numOfMatchesString = askNumOfMatches();
        return new String[]{carListString, numOfMatchesString};
    }

}
