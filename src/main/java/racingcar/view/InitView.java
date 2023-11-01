package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

public class InitView {

    private final InputValidator validator;

    public InitView(InputValidator validator) {
        this.validator = validator;
    }

    public String[] inputCarNames() {
        inputCarNameMessagePrint();

        String[] names = Console.readLine().split(",");

        validator.validateInputCarNames(names);

        return names;
    }



    public int inputTryNumber() {
        inputTryNumberMessagePrint();

        String number = Console.readLine();

        if (!validator.isNaturalNumber(number)) {
            throw new IllegalArgumentException("자연수가 아니므로 프로그램을 종료합니다.");
        }

        return Integer.parseInt(number);
    }

    private void inputCarNameMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 (,) 기준으로 구분)");
    }

    private void inputTryNumberMessagePrint() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
