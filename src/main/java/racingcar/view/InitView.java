package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InitView {

    public String[] inputCarNames() {
        inputCarNameMessagePrint();
        String names = Console.readLine();

        return names.split(",");
    }

    public int inputTryNumber() {
        inputTryNumberMessagePrint();
        String number = Console.readLine();

        return Integer.parseInt(number);
    }

    private void inputCarNameMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 (,) 기준으로 구분)");
    }

    private void inputTryNumberMessagePrint() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
