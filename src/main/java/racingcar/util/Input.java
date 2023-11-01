package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static List<String> readCarName() {
        String readLine = Console.readLine();

        validateRegex(readLine);

        List<String> carNames = splitNames(readLine);

        validateCarNamesSize(carNames);
        validateNameLength(carNames);

        return carNames;
    }

    private static void validateCarNamesSize(List<String> carNames) {
        if(carNames.size() < 2) {
            throw new IllegalArgumentException("2개 이상 입력해 주세요");
        }
    }

    private static List<String> splitNames(String readLine) {
        return Arrays.stream(readLine.split(","))
                .collect(Collectors.toList());
    }

    private static void validateNameLength(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateRegex(String readLine) {
        if(!readLine.contains(",")) {
            throw new IllegalArgumentException("쉼표로 구분되어야 합니다.");
        }
    }

    public static int readTryCount() {
        String readLine = Console.readLine();
        validateDigit(readLine);
        return Integer.parseInt(readLine);
    }

    private static void validateDigit(String readLine) {
        if(!readLine.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
