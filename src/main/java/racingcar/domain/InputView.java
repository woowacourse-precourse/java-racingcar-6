package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> getCarStrings() {
        List<String> carStrings = new ArrayList<>();
        String input = Console.readLine();
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 입력의 끝이 구분자로 끝날 수 없습니다.");
        }
        for (String carName : input.split(DELIMITER)) {
            validateNullOrEmpty(carName);
            carStrings.add(carName);
        }
        return carStrings;
    }

    public static int getMoveCount() {
        String input = Console.readLine();
        validateDigit(input);
        return Integer.parseInt(input);
    }

    private static void validateNullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 널이거나 빈 문자열입니다.");
        }
    }

    private static void validateDigit(String string) {
        validateNullOrEmpty(string);
        boolean isDigit = string.chars()
                .allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }
}
