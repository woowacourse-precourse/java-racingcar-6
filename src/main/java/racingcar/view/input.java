package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.util.validation_attempts;
import racingcar.util.validation_name;

import java.util.List;

public class input {

    public static List<String> input_names() {
        String names = Console.readLine();
        List<String> cars = validation_name.validation_name(names);
        return cars;
    }

    public static Integer input_attempts() {
        String attempts = Console.readLine();
        int n = validation_attempts.validation_attempts(attempts);
        return n;
    }

}
