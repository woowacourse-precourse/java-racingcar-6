package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MSG_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_COUNT = "시도할 회수는 몇회인가요?";

    public String[] inputCarNames(){
        System.out.println(MSG_NAME);
        return Console.readLine().split(",");
    }
    public String inputCounts(){
        System.out.println(MSG_COUNT);
        return Console.readLine();
    }
}
