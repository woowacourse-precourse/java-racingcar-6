package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CarNameValidator;
import racingcar.util.CommonValidator;

public class InputView {
    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        validateCarNameInput(inputCarName);
        return inputCarName;
    }

    private static void validateCarNameInput(String inputCarName) {
        CommonValidator.validateBlankCheck(inputCarName,"carNames");
        CarNameValidator.validateSpaceCheck(inputCarName);
    }

    public static String inputGameTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
