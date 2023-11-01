package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {

    public String randConsole() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }
}
