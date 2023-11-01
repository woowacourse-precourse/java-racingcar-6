package racingcar;

import static racingcar.Validator.carNamesValidation;
import static racingcar.Validator.checkIsPositiveInteger;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public static List<String> inputCarNames() {
        String carNames = Console.readLine();

        return parseCarNamesToList(carNames);
    }

    private static List<String> parseCarNamesToList(String carNames) {
        carNamesValidation(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());

        return carNameList;
    }

    public static int inputRepetitions() {
        String inputRepetitions = Console.readLine();

        return checkIsPositiveInteger(inputRepetitions);
    }
}
