package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    ValueCheck valueCheck = new ValueCheck();
    List<String> getCarNames() {
        String input = Console.readLine();

        valueCheck.inputContainsComma(input);

        List<String> carNameList = List.of(input.split(","));
        valueCheck.sizeUnderFive(carNameList);

        return carNameList ;
    }



    int getTurn() {
        String turn = Console.readLine();
        valueCheck.isInt(turn);

        return parseInt(turn);
    }

}
