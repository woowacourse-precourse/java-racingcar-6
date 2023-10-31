package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.utils.Constant.*;

public class OutputView {

    public void race(Result result, String[] name) {
        System.out.println(MSG_RESULT);
        for (int i = 0; i < result.getCount(); i++) {
            for (String n : name) {
                checkRaceScore(result, n);
                System.out.println(n + BLANK + COLON + BLANK + HYPHEN.repeat(result.getScore(n)));
            }
            System.out.println();
        }
    }

    private static void checkRaceScore(Result result, String name) {
        int randomNum = Randoms.pickNumberInRange(SD_RANDOM_MIN, SD_RANDOM_MAX);
        if (randomNum >= SD_RACE_ADVANCE) result.putScore(name, result.getScore(name) + RACE_ADVANCE);
    }

    public void getWinner(HashMap<String, Integer> participant) {

        List<String> keySet = new ArrayList<>(participant.keySet());
        keySet.sort((o1, o2) -> participant.get(o2).compareTo(participant.get(o1)));

        Integer maxScore = participant.get(keySet.get(0));

        String winner = participant.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxScore))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(COMMA + BLANK));

        System.out.println(MSG_WINNER + BLANK + COLON + BLANK + winner);
    }
}
