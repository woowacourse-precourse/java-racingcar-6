package racingcar.controller;

import java.util.List;
import racingcar.model.CarCreator;
import racingcar.service.UserService;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

public class GameController {
    private final OutputMessage outputMessage = new OutputMessage();
    private final InputMessage inputCarNameMessage = new InputMessage();
    private final UserService userService = new UserService();

    private final CarCreator carCreator = new CarCreator();


    public void StartGame() {
        inputCarNameMessage.inputCarNameMessage();
        List<String> carNames = carCreator.createCarList(userService.inputItem());
        inputCarNameMessage.inputTryNumberMessage();
    }


}
