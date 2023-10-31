package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MESSAGE_OF_REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_OF_REQUEST_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public String requestNames() {
        System.out.println(MESSAGE_OF_REQUEST_NAMES);
        return Console.readLine();
    }

    public void requestTryNumber() {
        System.out.println(MESSAGE_OF_REQUEST_TRY_NUMBER);
    }


}
