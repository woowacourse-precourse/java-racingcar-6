package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    static final String INVALID_INPUT_MESSAGE = "잘못된 입력으로 게임이 종료됩니다.";

    public List<String> getInput() {
        String input = Console.readLine();
        input = input.replace(" ", "");
        validateInput(input);
        return Arrays.asList(input.split(","));
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


}
