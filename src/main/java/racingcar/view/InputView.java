package racingcar.view;

import static racingcar.view.ConstantMessage.INPUT_CARS_NAME;
import static racingcar.view.ConstantMessage.TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.InputValidator;
import racingcar.util.Validator;

public class InputView implements View {
    private final InputValidator inputValidator;
    InputView(final Validator inputValidator) {
        this.inputValidator = (InputValidator) inputValidator;
    }

    public List<String> getUserInputName() {
        System.out.println(INPUT_CARS_NAME.message());
        String input = Console.readLine();

        List<String> nameList =  Arrays.stream(input.split(","))
                .collect(Collectors.toList());
        inputValidator.isValidList(nameList);

        return nameList;
    }

    public Integer getUserInputCount() {
        System.out.println(TRY_COUNT.message());
        return inputValidator.isPositiveInteger(Console.readLine());
    }
}
