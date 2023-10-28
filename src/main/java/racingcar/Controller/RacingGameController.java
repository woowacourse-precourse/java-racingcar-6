package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {

    Verification verification = new Verification();

    public List<String> inputCarName() {
        String input = Console.readLine();
        List<String> carNames = new ArrayList<>();

        carNames.addAll(Arrays.asList(splitInput(input)));

        verification.verifyCarName(carNames);

        return carNames;
    }

    public String[] splitInput(String input) {
        String[] splitedInput = input.split(",");

        return splitedInput;
    }

    public int inputTryCnt() {
        String input = Console.readLine();

        verification.verifyTryCnt(input);

        return Integer.parseInt(input);
    }
}
