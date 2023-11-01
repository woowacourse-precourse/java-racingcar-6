package racingcar.view;

import static racingcar.view.ConstantMessage.INPUT_CARS_NAME;
import static racingcar.view.ConstantMessage.TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.validator.InputValidator;
import racingcar.util.validator.Validator;

public class InputView implements View {
    private final InputValidator inputValidator;

    InputView(final Validator inputValidator) {
        this.inputValidator = (InputValidator) inputValidator;
    }

    /**
     * Console로 입력받은 문자열을 이름의 리스트로 변환하는 메서드.
     *
     * @return 이름 문자열 리스트
     */
    public List<String> getUserInputName() {
        System.out.println(INPUT_CARS_NAME.message());
        String input = Console.readLine();

        List<String> nameList = Arrays.stream(input.split(","))
                .collect(Collectors.toList());
        inputValidator.isValidList(nameList);

        return nameList;
    }

    /**
     * Console로 입력받은 문자열을 정수로 변환하는 메서드.
     *
     * @return int 타입 정수
     */
    public int getUserInputCount() {
        System.out.println(TRY_COUNT.message());
        String input = Console.readLine();
        Console.close();

        return inputValidator.isNonNegativeInteger(input);
    }
}
