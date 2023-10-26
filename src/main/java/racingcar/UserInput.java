package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    List<String> getCarNames() {
        String input = Console.readLine();
        List<String> carList = List.of(input.split(","));
        return carList;
    }
}
