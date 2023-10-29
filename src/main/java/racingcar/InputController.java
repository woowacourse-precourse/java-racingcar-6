package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputController {
    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        return validateTryCount(input);
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int validateTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}
