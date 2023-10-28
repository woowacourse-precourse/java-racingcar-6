package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String askCarName() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return Console.readLine();
    }
}
