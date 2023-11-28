package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력 하세요.(이름은 쉼표(,) 기준 으로 구분)";
    private static final String ENTER_RACE_ROUND = "시도할 회수는 몇 회 인가요?";
    @Override
    public String readCars() {
        System.out.println(ENTER_CAR_NAME);
        return readLine();
    }

    @Override
    public String readRound() {
        System.out.println(ENTER_RACE_ROUND);
        return readLine();
    }

    protected String readLine() {
        return Console.readLine();
    }
}
