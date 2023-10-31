package racingcar.view.input;

import static racingcar.constant.Constant.COMMA;
import static racingcar.exception.ErrorMessage.NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION;

import java.util.List;

public class InputView {
    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public List<String> names() {
        return List.of(consoleService.readLine().split(COMMA));
    }

    public long number() {
        try {
            return Long.parseLong(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION);
        }
    }
}
