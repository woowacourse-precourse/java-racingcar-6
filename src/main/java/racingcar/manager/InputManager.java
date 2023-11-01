package racingcar.manager;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidator;

public class InputManager {

    public String inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputTryCount() {

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();

        TryCountValidator.validateTryCountIsInteger(tryCount);

        return Integer.parseInt(tryCount);
    }
}
