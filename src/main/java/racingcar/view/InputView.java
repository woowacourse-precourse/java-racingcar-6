package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private static void validateDuplicateNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateIsNotEmpty(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private static void validateNoSpaces(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름 사이에 공백이 있습니다.");
        }
    }

    private static void validateFormat(String carName) {
        if (!carName.matches("[a-zA-Z0-9가-힣]+")) {
            throw new IllegalArgumentException("자동차 이름은 알파벳, 숫자, 한글만 사용 가능합니다.");
        }
    }

    private static int parseToInt(String input) {
        try {
            int progressCount = Integer.parseInt(input);
            validateIsPositive(progressCount);
            return progressCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }
    }

    private static void validateIsPositive(int progressCount) {
        if (progressCount <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상의 정수여야 합니다.");
        }
    }

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
                .peek(this::validateCarName)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private void validateCarName(String carName) {
        validateLength(carName);
        validateIsNotEmpty(carName);
        validateNoSpaces(carName);
        validateFormat(carName);

    }

}
