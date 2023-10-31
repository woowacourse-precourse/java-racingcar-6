package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private final String carNameInputString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String tryCountInputString = "시도할 회수는 몇회인가요?";

    public void generateCarNameInput() {
        System.out.println(carNameInputString);
        Console.readLine();
    }

    public void generateTryCountInput() {
        System.out.println(tryCountInputString);
        Console.readLine();
    }
}
