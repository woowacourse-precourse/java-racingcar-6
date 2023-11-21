package racingcar.Controller;

import racingcar.Service.UserInput;
import racingcar.View.InputView;

public class RacingCarController {
    InputView inputView;
    UserInput userInput = new UserInput();

    public void run() {
        inputView.printInputCarName();  //"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
        startCar();
    }

    private void startCar() throws IllegalAccessException {
        userInput.userInputCarName();
        userInput.tryNumber();
    }
}
