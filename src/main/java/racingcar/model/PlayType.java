package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum PlayType {
    STOP(1, Arrays.asList(0, 1, 2, 3)),
    GO(0, Arrays.asList(4, 5, 6, 7, 8, 9)),
    ;
    private int result;
    private List<Integer> randomNumbers;
    private static final String RANDOM_NUM_RANGE_EXCEPTION= "[ERROR] 임의의 숫자는 0-9사이의 수로 생성되어야 합니다.";
    private Function<Integer, Integer> expression;

    PlayType(int result, List<Integer> randomNumbers) {
        this.result = result;
        this.randomNumbers = randomNumbers;

    }

    public static PlayType findByNum(int number){
        return Arrays.stream(PlayType.values())
                .filter(playType -> playType.hasType(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RANDOM_NUM_RANGE_EXCEPTION));
    }

    private boolean hasType(int number) {
        return randomNumbers.stream()
                .anyMatch(integer -> randomNumbers.contains(number));
    }

}
