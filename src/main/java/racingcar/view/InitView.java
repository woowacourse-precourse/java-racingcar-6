package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidatior;

public class InitView {

    private final InputValidatior validator;

    public InitView(InputValidatior validator) {
        this.validator = validator;
    }

    public String[] inputCarNames() {
        inputCarNameMessagePrint();

        String[] names = Console.readLine().split(",");
        if (validator.isCarNamesUnderLength(names)) {
            throw new IllegalArgumentException("최소 한 개 이상의 자동차 이름이 필요합니다.");
        }

        return names;
    }

    public int inputTryNumber() {
        inputTryNumberMessagePrint();

        String number = Console.readLine();

        if (!validator.isNaturalNumber(number)) {
            throw new IllegalArgumentException("자연수가 아닙니다.\n자연수를 입력해주세요");
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
