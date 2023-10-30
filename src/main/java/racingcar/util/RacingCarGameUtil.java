package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameUtil {
    private static final int RACING_CAR_NAME_LENGTH = 5;
    private static final String SEPARATOR = ",";
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
}
