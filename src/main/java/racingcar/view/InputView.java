package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;

import static racingcar.Validator.hasNoConsecutiveCommas;
import static racingcar.Validator.validateNames;

public class InputView {
    public static String[] displayCarNamesInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();

        if (!(hasNoConsecutiveCommas(inputString) && validateNames(inputString))) {
            throw new IllegalArgumentException();
        }

        return inputString.split(",");
    }
}
