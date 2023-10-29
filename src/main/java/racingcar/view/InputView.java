package racingcar.view;

import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.RaceIOMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Validation;

public class InputView {

    public String inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        String nameInput = Console.readLine();
        validateInputBlank(nameInput);
        return nameInput;
    }

    public String inputRounds() {
        System.out.println(NUMBER_INPUT);
        String roundsInput = Console.readLine();
        validateInputBlank(roundsInput);
        return roundsInput;
    }

    public void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }
}