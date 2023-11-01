package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import racingcar.exception.Exception;
import racingcar.view.RacingView;

public class RacingService {

    private static final String STRING_REGEX = "^([A-Za-z]+(,[A-Za-z]+)+)$";
    private static final String INTEGER_REGEX = "^[0-9]+$";

    public static void racingGame(HashMap<String, String> cars, Integer round) {
        HashMap<String, String> game = forwardStopVehicle(cars, round);
        winnerCheck(game);
    }

    private static HashMap<String, String> forwardStopVehicle(HashMap<String, String> cars, Integer endRound) {
        int currentRound = 0;
        while (currentRound < endRound) {

            for (String str : cars.keySet()) {
                Integer num = pickNumber();
                if (num >= 4) {
                    cars.put(str, cars.get(str) + "-");
                }
            }
            for (Entry<String, String> entrySet : cars.entrySet()) {
                RacingView.roundTrackStatus(entrySet.getKey(), entrySet.getValue());
            }
            currentRound ++;
            System.out.println();
        }
        return cars;
    }

    private static String winnerCheck(HashMap<String, String> game) {
        String maxKey = null;
        String winner = null;

        for (String key : game.keySet()) {
            if (maxKey == null || game.get(key).length() >= game.get(maxKey).length()) {
                maxKey = key;
            }
        }

        for (String key : game.keySet()) {
            if (game.get(maxKey).length() == game.get(key).length()) {
                if (winner == null) {
                    winner = key;
                } else
                    winner = winner + ", " + key;
            }
        }
        System.out.println(winner);
        return winner;
    }

    public static HashMap<String, String> enterCarName(String args) {
        String car = stringValidation(args);
        HashMap<String, String> cars = new HashMap<>();
        String[] arr = car.split(",");
        for (String carName : arr) {
            cars.put(carName, "");
        }
        return cars;
    }

    public static Integer enterRoundNumber(String args) {
        return integerValidation(args);
    }

    public static Integer pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static String stringValidation(String args) {
        if (!Pattern.matches(STRING_REGEX, args)) {
            Exception.invalidValueEntered("잘못된 레이싱카 이름을 입력했습니다, 또는 기준을 잘못 입력했을 수 있습니다!");
        }
        return args;
    }

    private static Integer integerValidation(String args) {
        if (!Pattern.matches(INTEGER_REGEX, args)) {
            Exception.invalidValueEntered("잘못된 라운드 수를 입력했습니다, 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(args);
    }
}
