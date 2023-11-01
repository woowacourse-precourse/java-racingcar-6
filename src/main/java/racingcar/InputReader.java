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
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());

        carNamesValidation(carNames, carNameList);

        return carNameList;
    }

    public static int inputTrialTimes() {
        String inputTrialTimes = Console.readLine();

        return checkIsPositiveInteger(inputTrialTimes);
    }
}
