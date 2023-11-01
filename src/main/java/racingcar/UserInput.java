package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    String getCarNames() {
        ValueCheck valueCheck = new ValueCheck();

        String input = Console.readLine();

        valueCheck.inputContainsComma(input);

        return input;
    }

    int getTurn() {
        ValueCheck valueCheck = new ValueCheck();

        String turn = Console.readLine();
        valueCheck.isInt(turn);

        return parseInt(turn);
    }

}
