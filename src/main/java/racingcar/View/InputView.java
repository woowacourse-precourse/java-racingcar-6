package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String START_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printStartGuideMessage() {
        System.out.println(START_GUIDE_MESSAGE);
    }

    public void printRoundGuideMessage() {
        System.out.println(ROUND_GUIDE_MESSAGE);
    }

    public String getCarNames() {
        return Console.readLine();
    }

    public String getNumRound() {
        return Console.readLine();
    }
}
