package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public String inputTrialNumber() {
        System.out.println(TRY_MESSAGE);
        return Console.readLine();
    }

}
