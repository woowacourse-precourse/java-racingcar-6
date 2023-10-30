package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class Input {

    public static String inputString() {
        return Console.readLine();
    }

    public static List<String> getSplitList(String str) {
        return InputValidator.filterCarName(Arrays.asList(str.split(",")));
    }
}
