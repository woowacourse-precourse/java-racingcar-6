package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    private static final String NAME_SCAN_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ROUND_SCAN_MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    public String scanCarName() {
        System.out.println(NAME_SCAN_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String scanGameRound() {
        System.out.println(GAME_ROUND_SCAN_MESSAGE);
        return Console.readLine();
    }
}
