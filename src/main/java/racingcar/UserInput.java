package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    List<String> getCarNames() {
        String input = Console.readLine();
        List<String> carList = List.of(input.split(","));
        return carList;
    }

    Integer getTurn() {
        String turn = Console.readLine();
        return parseInt(turn);
    }

}
