package racingcar.domain.inputer;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.inputer.common.InputManager;

public class CarInputer {
    public static List<String> getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = InputManager.getInput();
        String[] names = userInput.split(",");
        return Arrays.asList(names);
    }
}
