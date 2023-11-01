package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return input;
    }
    public String readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        return input;
    }
}
