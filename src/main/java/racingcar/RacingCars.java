package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public final class RacingCars {
    private final List<String> names;

    private RacingCars() {
        List<String> names = createNamesWithInput(Console.readLine());
        validateCarNames(names);
        this.names = names;
    }

    public static RacingCars createRacingCars() {
        return new RacingCars();
    }

    private List<String> createNamesWithInput(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static void validateCarNames(List<String> names) {
        for (String name : names) {
            validateNameNotBlank(name);
            validateNameLength(name);
        }
    }

    private static void validateNameNotBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 제한길이를 초과할 수 없습니다.");
        }
    }
}
