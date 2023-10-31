package racingcar;

import java.util.LinkedHashMap;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    User user = new User();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LinkedHashMap<String, String> carList;

    public void run() {
        outputView.printMessage(Message.INPUT_CAR_NAME.getMessage());
        carList = inputView.getCarNameInput();
    }
}
