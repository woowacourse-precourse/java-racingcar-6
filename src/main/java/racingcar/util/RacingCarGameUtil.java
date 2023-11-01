package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameUtil {
    private static final int RACING_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final String SEPARATOR = ",";
    private static final String SEPARATOR_WITH_BLANK = ", ";
    private static final String GAUGE = "-";
    private static final String BLANK_WITH_CLONE = " : ";
    private RacingCarGameUtil() {}

    public static boolean validNameLength(String name) {
        if (name.length() <= RACING_CAR_NAME_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validNameType(Object name) {
        if (name instanceof String) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static List<String> splitName(Object names) {
        validNameType(names);
        String validatedNames = (String) names;
        return Arrays.stream(validatedNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static void viewDistance(int distance) {
        while (distance-- > RacingCarGame.ZERO) {
            OutputUtil.print(GAUGE);
        }
        OutputUtil.printLineChange();
    }

    public static void viewCarStatus(String name, int distance) {
        OutputUtil.print(name + BLANK_WITH_CLONE);
        viewDistance(distance);
    }

    public static String getResult(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(SEPARATOR_WITH_BLANK));
    }
}
