package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.ValidateBlankNameFormat;
import racingcar.validation.ValidateDuplicatedName;
import racingcar.validation.ValidateNumberFormat;
import racingcar.validation.ValidateStringLength;

public class InputView {
    private static final String carsNameInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCountInputMessage = "시도할 회수는 몇회인가요?";

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
        ValidateDuplicatedName.validate(value);
    }

    private String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }

    public void readInputTryCountMessage() {
        System.out.println(tryCountInputMessage);
    }

    public int getTryCount() {
        String input = Console.readLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateTryCount(String tryCount) {
        ValidateNumberFormat.validate(tryCount);
    }
}
