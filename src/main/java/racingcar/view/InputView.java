package racingcar.view;

import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.RaceIOMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Validation;

public class InputView {
    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }
    public String inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        String nameInput = Console.readLine();
        validateInputBlank(nameInput);
        return nameInput;
    }
    public int inputRounds() {
        System.out.println(NUMBER_INPUT);
        String roundsInput = Console.readLine();
        validateInputBlank(roundsInput);
        return validation.roundsNumeric(roundsInput);
    }

    public void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }
}