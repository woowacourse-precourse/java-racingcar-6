package racingcar.util;

import racingcar.app.RacingGameConst;
import racingcar.domain.collection.CarNames;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.app.RacingGameConst.*;

public class RacingGameValidator {

    public static void validateGameCount(final String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarName(
            final String input,
            final List<String> carNames,
            int count
    ) {
        for (int i = 0; i < count; i++) {
            String name = carNames.get(i);
            validateCarNameEmpty(name);
            validateCarNameLength(name);
            validateCarNameDuplicate(name, carNames);
        }
    }


    private static void validateCarNameEmpty(final String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(final String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateCarNameDuplicate(
            final String name,
            final List<String> carNames
    ) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public static void validateTrial(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}
