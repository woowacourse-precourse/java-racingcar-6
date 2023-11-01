package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public String[] readCarName() {
        String[] carNames = Console.readLine().split(",");
        return parseToNames(carNames);
    }

    public int readProgressCount() {
        String input = Console.readLine();
        return parseToInt(input);
    }

    private String[] parseToNames(String[] carNames) {
        validateDuplicateNames(carNames);
        return Arrays.stream(carNames)
                .map(String::trim)
                .peek(this:: validateCarName)
                .toArray(String[]::new);
    }

    private void validateCarName(String carName) {
        validateLength(carName);

    }

    private void validateLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateDuplicateNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }
    }

}
