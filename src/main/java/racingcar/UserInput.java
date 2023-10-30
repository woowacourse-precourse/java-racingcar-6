package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    public static List<String> carName() {
        String names = Console.readLine();
        List<String> carNames = List.of(names.split(","));
        return carNames;
    }

}
