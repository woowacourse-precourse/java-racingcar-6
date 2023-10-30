package racingcar.constant;

import java.util.List;

public class RacingTestConstant {
    public static final String SUCCESSFUL_CAR_NAMES = "pobi,woni,jun";
    public static final String SUCCESSFUL_MOVEMENT_TIME = "4";
    public static final String SUCCESSFUL_EXECUTION_RESULTS_1 = "pobi : ---";
    public static final String SUCCESSFUL_EXECUTION_RESULTS_2 = "woni : --";
    public static final String SUCCESSFUL_EXECUTION_RESULTS_3 = "jun : ---";
    public static final String SUCCESSFUL_FINAL_WINNERS = "최종 우승자 : pobi, jun";
    public static final List<Integer> RANDOM_NUMBERS = List.of(4, 2, 1, 3, 6, 4, 9, 2, 7, 5, 4, 8);
    public static final Integer RANDOM_NUMBERS_FIRST_ELEM = RANDOM_NUMBERS.get(0);
    public static final List<Integer> RANDOM_NUMBERS_REMAIN_ELEMS = RANDOM_NUMBERS.subList(1, RANDOM_NUMBERS.size());
}
