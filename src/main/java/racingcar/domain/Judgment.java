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

    public static HashMap<String, String> result = new HashMap<>();
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
            result.keySet().stream()
                    .map(key -> key + " : " + result.get(key))
                    .forEach(System.out::println);
            System.out.println();
        });
    }

    private void getExecutionResult(List<String> cars) {

        for (String car : cars) {
            String spaceMoved = "";

            int randomNum = getRandomNumber();

            result.putIfAbsent(car, spaceMoved);

            if (canMoveForward(randomNum)) {
                spaceMoved = result.get(car);
                spaceMoved += "-";
                result.put(car, spaceMoved);
            }
        }

    }

    public List<String> getResultWinner() {
        int max = Collections.max(result.values()).length();

        return result.keySet().stream()
                .filter(key -> result.get(key).length() == max)
                .collect(Collectors.toList());
    }

    private boolean canMoveForward(int randomNum) {
        return randomNum >= 4;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(OFFSET, LIMIT);
    }
}