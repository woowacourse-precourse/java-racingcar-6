package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> userInputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return InputValidation.inputValidate(
                Arrays.stream(Console.readLine().split(",")).toList());
    }
}
