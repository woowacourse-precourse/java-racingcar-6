package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final  String INSERT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final  String INSERT_TRY_NUMBER = "시도할 회수는 몇회인가요?\n";

    public String readCarNames() {
        System.out.print(INSERT_NAMES);
        return Console.readLine();
    }

    public String readTryNumber() {
        System.out.println(INSERT_TRY_NUMBER);
        return Console.readLine();
    }
}
