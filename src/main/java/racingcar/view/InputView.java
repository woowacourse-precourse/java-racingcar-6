package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {

    }

    public static String getCarsName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String getTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
