package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {
    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return splitByComma(Console.readLine());
    }

    public static String[] splitByComma(String input) {
        return Validator.isValidName(input.split(","));
    }
}
