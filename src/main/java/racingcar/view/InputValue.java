package racingcar.view;

import racingcar.exception.Validator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    public static List<String> getRacingCarsNames() {

        String input = getInputValue();

        Validator.name_null_check(input);

        Validator.character_check(input);

        List<String> names = stringToStringArr(input);

        Validator.name_size_check(names);

        Validator.name_duplication_check(names);

        return names;
    }

    public static int getRacingRange() {

        String input = getInputValue();

        Validator.number_check(input);

        return Integer.parseInt(input);
    }

    private static String getInputValue() {

        String input = readLine();

        return input.replaceAll(" ", "");
    }

    private static List<String> stringToStringArr(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
