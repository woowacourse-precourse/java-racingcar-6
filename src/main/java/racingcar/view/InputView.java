package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private static final String GET_CAR_NAMES_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_TRIAL_NUMBER_SENTENCE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(GET_CAR_NAMES_SENTENCE);
        return Console.readLine();
    }

    public static String inputTrialNumber() {
        System.out.println(GET_TRIAL_NUMBER_SENTENCE);
        return Console.readLine();
    }

}
