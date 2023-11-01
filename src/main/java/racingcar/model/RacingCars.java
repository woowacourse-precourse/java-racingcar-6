package racingcar.model;

import static racingcar.constant.InputError.BLANK_CAR_NAME;
import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;
import static racingcar.constant.RaceConfig.CAR_NAME_LENGTH_LIMIT;
import static racingcar.constant.RaceConfig.INITIAL_CAR_POSITION;
import static racingcar.constant.RaceConfig.INPUT_SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.platform.commons.util.StringUtils;

public final class RacingCars {
    private final List<String> names;

    private RacingCars(String input) {
        List<String> names = createNamesWithInput(input);
        validateNamesEmpty(names);
        validateCarNames(names);
        this.names = names;
    }

    public static RacingCars createRacingCars(String input) {
        return new RacingCars(input);
    }

    private List<String> createNamesWithInput(String input) {
        return Arrays.stream(input.split(INPUT_SPLIT_DELIMITER))
                .toList();
    }

    private void validateCarNames(List<String> names) {
        for (String name : names) {
            validateNameNotBlank(name);
            validateNameLength(name);
        }
    }

    private void validateNamesEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.toString());
        }
    }

    private void validateNameNotBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.toString());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEEDED_LIMIT_CAR_LENGTH.toString());
        }
    }

    public Map<String, Integer> createInitPosition() {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String name : names) {
            linkedHashMap.put(name, INITIAL_CAR_POSITION);
        }
        return linkedHashMap;
    }
}
