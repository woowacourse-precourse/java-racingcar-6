package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Judgment {
    private static final int OFFSET = 1;
    private static final int LIMIT = 9;
    private static final HashMap<String, String> RESULT = new HashMap<>();
    private static Judgment judgment;

    private Judgment() {
    }

    public static Judgment getInstance() {
        if (judgment == null) {
            return judgment = new Judgment();
        }
        return judgment;
    }

    public void executeForCount(int count, List<String> cars) {
        IntStream.range(0, count).forEach(i -> {
            judgment.getExecutionResult(cars);
            RESULT.keySet().stream()
                    .map(key -> key + " : " + RESULT.get(key))
                    .forEach(System.out::println);
            System.out.println();
        });
    }

    private void getExecutionResult(List<String> cars) {

        for (String car : cars) {
            String spaceMoved = "";

            int randomNum = getRandomNumber();

            RESULT.putIfAbsent(car, spaceMoved);

            if (canMoveForward(randomNum)) {
                spaceMoved = RESULT.get(car);
                spaceMoved += "-";
                RESULT.put(car, spaceMoved);
            }
        }
    }

    public List<String> getResultWinner() {
        int max = Collections.max(RESULT.values()).length();

        return RESULT.keySet().stream()
                .filter(key -> RESULT.get(key).length() == max)
                .collect(Collectors.toList());
    }

    private boolean canMoveForward(int randomNum) {
        return randomNum >= 4;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(OFFSET, LIMIT);
    }
}