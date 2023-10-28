package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public String askCarName(){
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public String askAttemptNumber(){
        System.out.println(ASK_ATTEMPT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
