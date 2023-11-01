package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;

public final class NameValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private final static String DUPLICATION_NAME_MESSAGE = "중복된 자동차 이름을 사용할 수 없습니다";
    private static final String EXCEED_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하만 가능 합니다.";

    private NameValidator() {
    }

    public static void checkDuplicationName(List<String> names) {
        names.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .values()
                .stream()
                .filter(c -> c >= 2)
                .findFirst()
                .ifPresent(n -> {
                    throw new IllegalArgumentException(DUPLICATION_NAME_MESSAGE);
                });
    }

    public static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_MESSAGE);
        }
    }

}
