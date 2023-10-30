package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    static final String INVALID_INPUT_MESSAGE = "잘못된 입력으로 게임이 종료됩니다.";
    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 10;

    public List<String> getCarNames() {
        String input = Console.readLine();
        input = input.replace(" ", "");
        validateInput(input);
        return Arrays.asList(input.split(","));
    }

    public int getRaceCount() {
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        String[] splitInput = input.split(",");

        if (splitInput.length < 2 || splitInput.length > 5) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        Set<String> set = new HashSet<>();
        for (String carName : splitInput) {
            if (carName == null || carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
            set.add(carName);
        }
        if (set.size() != splitInput.length) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private void validateCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < MIN_RACE_COUNT || MAX_RACE_COUNT < count) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }


}
