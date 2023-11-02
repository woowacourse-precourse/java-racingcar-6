package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TOTAL_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public String readCarNames() {
        System.out.println(ASK_NAME_MESSAGE);
        return Console.readLine();
    }

    public String readTotalRound() {
        System.out.println(ASK_TOTAL_ROUND_MESSAGE);
        return Console.readLine();
    }
}
