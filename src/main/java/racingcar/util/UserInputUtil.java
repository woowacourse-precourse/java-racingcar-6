package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;


public class UserInputUtil {

    public static List<String> getCarNames() {
        System.out.println(RacingCarConstant.INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        validateCarNamesInput(input);
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return carNames;
    }

    private static void validateCarNamesInput(String input) {
        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,") || input.trim().isEmpty()) {
            throw new IllegalArgumentException(RacingCarConstant.INVALID_CAR_NAMES_INPUT);
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(RacingCarConstant.INVALID_CAR_NAMES_INPUT);
            }
        }
    }
}
