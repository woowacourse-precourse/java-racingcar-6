package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNames(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public String inputAttemptNumber() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
