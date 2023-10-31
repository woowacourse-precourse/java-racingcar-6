package racingcar.view;

import racingcar.exception.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    public static String[] getRacingCarsNames() {

        String input = getInputValue();

        String[] names = stringToStringArr(input);

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

    private static String[] stringToStringArr(String input) {
        return input.split(",");
    }
}
