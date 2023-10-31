package racingcar;

import static racingcar.Validator.validateInputFormat;
import static racingcar.Validator.validateInputInRange;
import static racingcar.Validator.validateInputIsNumeric;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateInputFormat(carNames);
        //validateNotDuplicated(carNames);
        return carNames;
    }

    public int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        validateInputIsNumeric(tryCount);
        validateInputInRange(tryCount);
        return Integer.parseInt(tryCount);
    }
}
