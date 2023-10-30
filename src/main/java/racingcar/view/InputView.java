package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant;

public class InputView {

    private static InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    //사용자에게 자동차 이름 입력 받기
    public String carsInput() {
        System.out.println(Constant.START_NAME_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }
}
