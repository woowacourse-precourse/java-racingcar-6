package racingcar.view;

import racingcar.handler.InputHandler;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.handler.ErrorHandler.INVALID_INPUT;
import static racingcar.handler.ErrorHandler.INVALID_NUMBER;

public class ConsoleInput implements InputHandler {

    @Override
    public List<String> inputCarNames() {
        return stringToList(readLine());
    }

    @Override
    public int inputTryCount() {
        return stringToInt(readLine());
    }

    private List<String> stringToList(String input) {
        try {
            return List.of(input.split(","));
        } catch (Exception e) {
            throw INVALID_INPUT.getException();
        }
    }

    private int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw INVALID_NUMBER.getException();
        }
    }
}
