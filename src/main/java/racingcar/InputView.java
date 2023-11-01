package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static String[] inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        checkDuplicateNames(carNames);
        for (String name : carNames) {
            validateCarName(name);
        }
    }

    private static void checkDuplicateNames(String[] carNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(carNames));
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException("같은 이름을 가진 자동차가 있습니다.");
        }
    }

    private static void validateCarName(String name) {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.");
        }
        if (hasWhitespace(name)) {
            throw new IllegalArgumentException("자동차 이름에는 공백을 포함할 수 없습니다.");
        }
    }

    private static boolean isInvalidLength(String name) {
        return name.isEmpty()  || name.length() > CAR_NAME_MAX_LENGTH;
    }

    private static boolean hasWhitespace(String name) {
        return name.trim().length() != name.length();
    }

    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String attemptInput = Console.readLine();
        return validateAttempt(attemptInput);
    }

    private static int validateAttempt(String attemptInput) {
        try {
            int attemptCount = Integer.parseInt(attemptInput);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 양수여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
