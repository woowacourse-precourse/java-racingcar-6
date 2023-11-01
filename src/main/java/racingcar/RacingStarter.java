package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.ExceptionHandler;

public class RacingStarter {

    private String[] inputs;
    private int repeatCount;
    private Racing racing;

    public RacingStarter() {
    }

    public void racingStart() {

        racing = new Racing();
        inputs = nameInput();
        repeatCount = repeatCountInput();
        racing.racingRun(inputs, repeatCount);
    }

    private String[] nameInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.");
        return ExceptionHandler.checkNameInputException(Console.readLine());
    }

    private int repeatCountInput() {

        System.out.println("시도할 회수는 몇회인가요?");
        return ExceptionHandler.checkRepeatCountInputException(Console.readLine());
    }
}
