package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.Validator;

public class InputValue {

    public static String[] getRacingCarsNames() {

        String input = Console.readLine();

        String temp = input.replaceAll(" ", "");

        String[] names = temp.split(",");

        Validator.name_size_check(names);

        Validator.name_duplication_check(names);

        return names;
    }

    public static int getRacingRange() {

        String input = Console.readLine();

        String temp = input.replaceAll(" ", "");

        Validator.number_check(temp);

        return Integer.parseInt(temp);
    }

}
