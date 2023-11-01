package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CARS_MENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUNT_MENT = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CARS_MENT);
        return Console.readLine();
    }

    public String inputHowManyRound() {
        System.out.println(INPUT_ROUNT_MENT);
        return Console.readLine();
    }
}
