package racingcar;

import java.util.List;

public class Calculator {

    public static int calculateMax(List<Integer> totalMoveList) {
        int max = totalMoveList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(-1);

        return max;
    }
}
