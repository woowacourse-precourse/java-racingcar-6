package racingcar.Util;

import java.util.List;

public class Compare {

    private static String CAR_NO_MOVE = "자동차가 이동하지 않았습니다.";

    public static List<Integer> number(List<Integer> carListCount, List<Integer> location) {
        increaseGoAndStopCount(carListCount, location);
        return location;
    }

    private static void increaseGoAndStopCount(List<Integer> carListCount, List<Integer> location) {
        for (int i = 0; i < location.size(); i++) {
            if (carListCount.get(i) > 3) {
                location.set(i, location.get(i) + 1);
            }
        }
    }
}