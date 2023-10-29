package racingcar;

import static racingcar.constant.InputError.BLANK_CAR_NAME;
import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.platform.commons.util.StringUtils;

public final class RacingCars {
    private final List<String> names;

    private RacingCars(String input) {
        List<String> names = createNamesWithInput(input);
        validateCarNames(names);
        this.names = names;
    }

    public static RacingCars createRacingCars(String input) {
        return new RacingCars(input);
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
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(EXCEEDED_LIMIT_CAR_LENGTH.getMessage());
        }
    }

    public Map<String, Integer> createInitPosition() {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String name : names) {
            linkedHashMap.put(name, 0);
        }
        return linkedHashMap;
    }
}
