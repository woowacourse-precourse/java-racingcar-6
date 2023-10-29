package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.validation_name;

public class input {

    public static String input_names() {
        String names = Console.readLine();
        validation_name.validation_name(names);
        return names;
    }

}
