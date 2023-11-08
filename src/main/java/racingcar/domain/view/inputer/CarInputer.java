package racingcar.domain.view.inputer;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.view.inputer.common.InputManager;
import racingcar.domain.view.printer.GameStartPrinter;

public class CarInputer {
    private static final String COMMA = ",";

    public static List<String> getName() {
        GameStartPrinter.printCarName();
        String userInput = InputManager.getInput();
        String[] names = userInput.split(COMMA);

        return Arrays.asList(names);
    }
}
