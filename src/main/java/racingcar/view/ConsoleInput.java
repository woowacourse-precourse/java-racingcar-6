package racingcar.view;

import racingcar.handler.InputHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements InputHandler {

    @Override
    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return readLine();
    }

    @Override
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }
}
