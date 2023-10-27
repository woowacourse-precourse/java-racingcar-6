package racingcar.view;

import static racingcar.view.Constants.INPUT_CARS_NAME_MESSAGE;
import static racingcar.view.Constants.TRY_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.InputValidator;
import racingcar.util.Validator;

public class InputView {
    private final InputValidator inputValidator = Validator.generateInputValidator();

    public List<String> getUserInputName() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
        String input = Console.readLine();

        List<String> nameList =  Arrays.stream(input.split(","))
                .collect(Collectors.toList());
        inputValidator.isValidList(nameList);

        return nameList;
    }

    public Integer getUserInputCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return inputValidator.isNumber(Console.readLine());
    }
}
