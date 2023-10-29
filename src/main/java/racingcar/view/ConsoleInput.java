package racingcar.view;

import racingcar.handler.InputHandler;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.handler.ConstantsHandler.SPLIT_DELIMITER;
import static racingcar.handler.ErrorHandler.INVALID_INPUT;

public class ConsoleInput implements InputHandler {

    @Override
    public List<String> inputCarNames() {
        return stringToList(readLine());
    }

    @Override
    public String inputTryCount() {
        return readLine();
    }

    private List<String> stringToList(String input) {
        try {
            return List.of(input.split(SPLIT_DELIMITER));
        } catch (Exception e) {
            throw INVALID_INPUT.getException();
        }
    }
}
