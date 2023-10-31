package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.Util;

public class InputView {
    public List<String> inputToNameCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> inputs = Util.splitNameByComma(Console.readLine());
        checkNameLength(inputs);
        return inputs;
    }

    public int inputTryToMoveCar() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Util.convertStringToInt(Console.readLine());
        return input;
    }

    private void checkNameLength(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 입력할 수 있습니다.");
            }
        }
    }
}
