package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    ValueCheck valueCheck = new ValueCheck();

    List<String> getCarNames() {
        String input = Console.readLine();
        List<String> trimmedCarNames;

        valueCheck.inputContainsComma(input);

        List<String> carNameList = List.of(input.split(","));
        trimmedCarNames = trimInput(carNameList);

        valueCheck.sizeUnderFive(carNameList);

        return trimmedCarNames;
    }

    List<String> trimInput(List<String> carNameList) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String car : carNameList) {
            String trimmedCar = car.trim();
            trimmedCarNames.add(trimmedCar);
        }
        return trimmedCarNames;
    }

    int getTurn() {
        String turn = Console.readLine();
        valueCheck.isInt(turn);

        return parseInt(turn);
    }

}
