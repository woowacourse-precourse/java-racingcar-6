package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.NumberValidator;

public class GameInputView {

    public static String getUserCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int getTotalRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        NumberValidator.validateAttemptCount(userInput);
        return Integer.parseInt(userInput);
    }

}