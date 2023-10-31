package racingcar.view.input;

import static racingcar.constant.Constant.COMMA;

import java.util.List;

public class InputView {
    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public List<String> names() {
        return List.of(consoleService.readLine().split(COMMA));
    }
}
