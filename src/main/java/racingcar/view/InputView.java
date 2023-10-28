package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern CAR_NAMES_REGEX = Pattern.compile("^[^,\\s]+(?:,[^,\\s]+)*$");

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (invalidCarNamesRegex(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static boolean invalidCarNamesRegex(String input) {
        return !CAR_NAMES_REGEX.matcher(input).matches();
    }

    public static int readNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }
}
