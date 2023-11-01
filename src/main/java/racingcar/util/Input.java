package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Input {

    public static List<String> readCarName() {
        String readLine = Console.readLine();

        InputValidator.validateRegex(readLine);
        InputValidator.validateCharacter(readLine);
        List<String> carNames = splitNames(readLine);

        InputValidator.validateDuplicate(carNames);
        InputValidator.validateCarNamesSize(carNames);
        InputValidator.validateNameLength(carNames);

        return carNames;
    }

    private static List<String> splitNames(String readLine) {
        return Arrays.stream(readLine.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int readTryCount() {
        String readLine = Console.readLine();
        InputValidator.validateDigit(readLine);
        return Integer.parseInt(readLine);
    }
}
