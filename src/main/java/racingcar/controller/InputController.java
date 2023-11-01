package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import static racingcar.utils.Error.*;

import java.util.Arrays;

public class InputController {
    public Cars getCarNameFromUserInput(){
        String input = Console.readLine();
        return new Cars(Arrays.asList(input.split(",")));
    }

    public int getAttemptCountFromUserInput(){
        String input = Console.readLine();
        int inputToInt = 0;

        try {
            inputToInt = Integer.parseInt(input);
        } catch (Exception e) {
            throwError(INVALID_ATTEMPT_INPUT);
        }

        if (inputToInt < 0)
            throwError(INVALID_ATTEMPT_INPUT);

        return inputToInt;
    }
}
