package racingcar.domain;

import static racingcar.constants.Messages.PROMPT_CAR_NAMES;
import static racingcar.constants.Messages.PROMPT_RACE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Validator;

public class User {
    Validator validator = new Validator();



    public List<String> getCarNames() {
        System.out.println(PROMPT_CAR_NAMES);
        String input = Console.readLine();
        input = input.replace(" ", "");
        validateInput(input);
        return Arrays.asList(input.split(","));
    }

    public int getRaceCount() {
        System.out.println(PROMPT_RACE_COUNT);
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        validator.validateInput(input);
        validator.validateNameCount(input);
        validator.validateNameLength(input);
        validator.validateUniqueName(input);
    }

    private void validateCount(String input) {
        validator.validateInput(input);
        validator.validateMoveCount(input);

    }


}