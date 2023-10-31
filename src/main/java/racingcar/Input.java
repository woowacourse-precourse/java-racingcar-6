package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    Exception exception = new Exception();
    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        exception.validateInputNotStartWithComma(input);
        exception.validateInputContainsConsecutiveCommas(input);
    }
}
