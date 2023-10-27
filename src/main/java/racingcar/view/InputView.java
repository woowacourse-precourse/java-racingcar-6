package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)";
    private static final String TRIAL_TIMES = "시도할 횟수는 몇회인가요?";

    public String askCarsName() {
        System.out.println(CAR_NAME);
        return Console.readLine();
    }

    public String askTrialTimes() {
        System.out.println(TRIAL_TIMES);
        return Console.readLine();
    }
}