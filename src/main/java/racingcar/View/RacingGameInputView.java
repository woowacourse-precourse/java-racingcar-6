package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInputView {
    public String nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputs = Console.readLine();
        return inputs;
    }

    public String turnsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return input;
    }
}
