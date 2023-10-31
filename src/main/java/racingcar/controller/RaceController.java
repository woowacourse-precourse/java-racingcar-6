package racingcar.controller;

import static racingcar.validator.InputValidator.validateCarListString;
import static racingcar.validator.InputValidator.validateNumOfMatches;
import static racingcar.view.InputView.askCarList;
import static racingcar.view.InputView.askNumOfMatches;
import static racingcar.view.OutputView.printPerMatchResult;
import static racingcar.view.OutputView.printSystemMessage;
import static racingcar.view.OutputView.printWinner;
import static racingcar.view.SystemMessage.TESTING;

import racingcar.model.Race;

public class RaceController {
    public static void run() {
        // 1. 자동차 이름 입력 받기
        String carListString = askCarList();
        validateCarListString(carListString);

        // 2. 경기 횟수 입력 받기
        String numOfMatchesString = askNumOfMatches();
        validateNumOfMatches(numOfMatchesString);

        // 3. 경기 과정 및 결과 출력
        Race race = new Race(carListString, numOfMatchesString);
        printSystemMessage(TESTING);
        for (int i = 0; i < race.getNumOfMatches(); i++) {
            race.match();
            printPerMatchResult(race.getPerMatchResult());
        }
        printWinner(race.getWinner());
    }
}
