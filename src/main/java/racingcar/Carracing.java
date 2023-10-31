package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static racingcar.NumberConst.*;
import static racingcar.InputValue.*;
import static racingcar.PrintUtil.*;

public class Carracing {

    public static Map<String, String> raceScore;

    public static void startRacing() {

        inputSettingValue();

        printResultMsg();

        setInitStartPoint(carNameList);
        for (int i = 0; i < movingCount; i++) {
            goStop();
        }
        printFinalResultMsg();
        chooseWinner();
    }

    public static void goStop() {

        for (String carName : carNameList) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, FINAL_INCLUSIVE_NUMBER);

            move(carName, randomNumber);
        }
        printGameResultMsg(raceScore);
    }

    public static void move(String carName, int randomNumber) {
        if (randomNumber >= STANDARD_MOVING_NUMBER) {
            raceScore.put(carName, raceScore.get(carName) + "-");
        }
    }

    public static Map<String, String> setInitStartPoint(String[] carNameList) {

        raceScore = new LinkedHashMap<>();

        for (String carName : carNameList) {
            raceScore.put(carName, "");
        }

        return raceScore;
    }

    public static void chooseWinner() {
        List<String> winner = new ArrayList<>(raceScore.keySet());

        winner = sortRanking(winner);

        printWinnerMsg(raceScore, winner);
    }

    public static List<String> sortRanking(List<String> winner) {
        winner.sort((o1, o2) -> raceScore.get(o2).compareTo(raceScore.get(o1)));

        return winner;
    }
}
