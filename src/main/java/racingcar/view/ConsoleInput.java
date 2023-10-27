package racingcar.view;

import racingcar.handler.InputHandler;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.handler.ErrorHandler.INVALID_INPUT;
import static racingcar.handler.ErrorHandler.INVALID_NUMBER;

public class ConsoleInput implements InputHandler {

    @Override
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return stringToList(readLine());
    }

    @Override
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
