package racingcar.controller;
import racingcar.view.*;
import racingcar.controller.GameUtils;
public class GameController {
    OutputView getMessage = new OutputView();
    InputView putMessage = new InputView();
    GameUtils gameUtility = new GameUtils();
    public void run(){
        getMessage.GameStartMessage();
        String s = putMessage.getPlayerInput();
        // 게임 흐름과 관련된 로직
    }
}
