package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.Input;
import racingcar.model.UserInputData;
import racingcar.view.Description;
import racingcar.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    static Map<String, StringBuilder> racer;
    static UserInputData gameStartData;

    public static void run() {
        gameStartData = Input.inputGameInfo();

        initializeMap();

        for (int i = 0; i < gameStartData.loopCount; ++i) {
            executeStep();

            View.showCurrentState(racer);
        }

        var winner = makeResult();
        String winnerString = String.join(", ", winner);
        View.show(Description.WINNER + winnerString);

    }

    private static void initializeMap() {
        racer = new HashMap<>();
        for (String name : gameStartData.carName) {
            racer.put(name, new StringBuilder());
        }
    }

    /**
     * 한번 진행시키기
     */
    private static void executeStep() {
        final int LEAST_POWER = 4;
        final int POWER_MIN = 0;
        final int POWER_MAX = 9;
        for (StringBuilder sb : racer.values()) {
            int forwardPower = Randoms.pickNumberInRange(POWER_MIN, POWER_MAX);
            if (forwardPower < LEAST_POWER) continue;
            sb.append('-');
        }

    }

    /**
     * 결과 목록 구하기
     *
     * @return 최종 우승자 목록
     */
    private static List<String> makeResult() {
        int maxLength = 0;
        for (var sb : racer.values()) {
            if (maxLength < sb.length()) {
                maxLength = sb.length();
            }
        }


        int finalMaxLength = maxLength;
        return racer.keySet()
                .stream()
                .filter(key -> finalMaxLength == racer.get(key).length())
                .toList();
    }

}
