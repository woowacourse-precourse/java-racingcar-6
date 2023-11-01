package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Configuration;
import racingcar.view.InputView;

public class InputController {

    public static List<String> nameInputController() {
        List<String> names;
        String input;

        System.out.println(InputView.nameInputView());
        input = Console.readLine();

        names = splitNames(input);

        if (!validNames(names)) {
            throw new IllegalArgumentException();
        }

        return names;
    }

    public static int countInputController() {
        String inputValue;
        int count;

        System.out.println(InputView.countInputView());
        inputValue = Console.readLine();

        count = validCount(inputValue);

        return count;
    }

    private static int validCount(String input) {
        int count;

        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (count < 0) {
            throw new IllegalArgumentException();
        }

        return count;
    }

    public static boolean validNames(List<String> names) {
        for (String name : names) {
            if (!validName(name)) {
                return false;
            }
        }

        return true;
    }

    private static boolean validName(String name) {
        if (name.length() == 0
                || name.length() > Configuration.maxNameSize) {
            return false;
        }

        return true;
    }

    public static ArrayList splitNames(String names) {
        return new ArrayList(Arrays.asList(names.split(",")));
    }
}
