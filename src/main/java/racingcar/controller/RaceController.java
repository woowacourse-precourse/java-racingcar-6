package racingcar.controller;

import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;

import java.util.List;
import java.util.Map;
import racingcar.model.Race;

public class RaceController {
    public static void run() {
        String carListString = askCarList();
        String numOfMatchesString = askNumOfMatches();
        Race race = new Race(carListString, numOfMatchesString);
        List<Map<String, Integer>> allMatchesResult = race.getAllMatchesResult();


    }

}
