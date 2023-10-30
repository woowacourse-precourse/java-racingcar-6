package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String informInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int informInputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNumber = Console.readLine();
        return Integer.parseInt(stringNumber);
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public int inputTryNumber() {
        String numberString = Console.readLine();
        return Integer.parseInt(numberString);
    }
}
