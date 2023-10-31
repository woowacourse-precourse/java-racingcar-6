package racingcar.domain;

import static racingcar.constants.Messages.INVALID_INPUT_ERROR;
import static racingcar.constants.Messages.PROMPT_CAR_NAMES;
import static racingcar.constants.Messages.PROMPT_RACE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 10;

    public List<String> getCarNames() {
        System.out.println(PROMPT_CAR_NAMES);
        String input = Console.readLine();
        input = input.replace(" ", "");
        validateInput(input);
        return Arrays.asList(input.split(","));
    }

    public int getRaceCount() {
        System.out.println(PROMPT_RACE_COUNT);
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        String[] splitInput = input.split(",");
        if (splitInput.length < 2 || splitInput.length > 5) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        Set<String> set = new HashSet<>();
        for (String carName : splitInput) {
            if (carName == null || carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
            set.add(carName);
        }
        if (set.size() != splitInput.length) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

    }

    private void validateCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < MIN_RACE_COUNT || MAX_RACE_COUNT < count) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
