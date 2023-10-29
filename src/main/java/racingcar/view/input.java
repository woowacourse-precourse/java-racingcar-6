package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.validation_name;
import racingcar.util.validation_attempts;

public class input {

    public static String input_names() {
        String names = Console.readLine();
        validation_name.validation_name(names);
        return names;
    }

    public static Integer input_attempts() {
        String attempts = Console.readLine();
        int n = validation_attempts.validation_attempts(attempts);
        return n;
    }

}
