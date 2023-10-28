package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.ValidateBlankNameFormat;
import racingcar.validation.ValidateStringLength;

public class InputView {
    private static final String carsNameInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void readInputCarNameMessage() {
        System.out.println(carsNameInputMessage);
    }

    public String[] getCarsName() {
        String input = Console.readLine();
        validateInputValue(input);
        return splitCarsName(input);
    }

    private void validateInputValue(String value) {
        ValidateBlankNameFormat.validate(value);
        ValidateStringLength.validate(value);
    }

    private String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }
}
