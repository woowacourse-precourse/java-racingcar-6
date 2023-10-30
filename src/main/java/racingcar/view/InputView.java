package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputView {
    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_PROMPT = "시도할 회수는 몇회인가요?";


    public List<String> readCarNames() {
        System.out.println(CAR_NAME_INPUT_PROMPT);
        String input = Console.readLine();
        List<String> names = splitAndTrimInput(input);

        validateNotEmpty(names);
        validateDuplicate(names);
        return names;
    }

    private List<String> splitAndTrimInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }


    private void validateNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_SIZE_ERROR.getMessage());
        }
    }

    public int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_PROMPT);
        int tryCount = readLineAndParseInt();
        validateNonNegative(tryCount);
        return tryCount;
    }

    private int readLineAndParseInt() {
        try {
            String input = Console.readLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR.getMessage());
        }
    }

    private void validateNonNegative(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_INPUT_NON_NEGATIVE_ERROR.getMessage());
        }
    }

}
