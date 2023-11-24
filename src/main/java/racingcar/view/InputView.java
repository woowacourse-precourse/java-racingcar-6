package racingcar.view;

import racingcar.util.exception.ConsoleException;
import racingcar.util.exception.GlobalException;
import racingcar.util.message.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class InputView {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readConsole() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new ConsoleException(String.format(ExceptionMessage.INPUT_MESSAGE.getValue(), e.getMessage()));
        }
    }

    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (GlobalException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }
}
