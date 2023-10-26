package racingcar.controller;

import racingcar.view.OutputMessage;

public class GameController {
    private final OutputMessage outputMessage = new OutputMessage();


    public void StartGame(){
        outputMessage.inputCarNameMessage();
    }

}
