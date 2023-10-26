package racingcar.view;

import racingcar.handler.InputHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.handler.ErrorHandler.INVALID_NUMBER;

public class ConsoleInput implements InputHandler {

    @Override
    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return readLine();
    }

    @Override
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw INVALID_NUMBER.getException();
        }
    }
}
