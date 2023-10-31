package racingcar.view.input;

import static racingcar.constant.Constant.COMMA;
import static racingcar.constant.Constant.ENTER;
import static racingcar.constant.Constant.INPUT_CAR_NAMES;
import static racingcar.constant.Constant.INPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.exception.ErrorMessage.NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION;

import java.util.List;

public class InputView {
    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public List<String> names() {
        System.out.println(INPUT_CAR_NAMES);
        return List.of(consoleService.readLine().split(COMMA));
    }

    public long number() {
        try {
            System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
            long number = Long.parseLong(consoleService.readLine());
            System.out.print(ENTER);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION);
        }
    }
}
