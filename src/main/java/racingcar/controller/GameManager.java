package racingcar.controller;

import racingcar.model.GameSettingsDto;

public class GameManager {
    private GameSettingsDto gameSettingsDto;

    private UserInput userInput;

    public GameManager(){
        userInput = new UserInput();
    }

    public void startGame(){
        gameSettingsDto = userInput.readUserGameSettingInput();

    }
}
