package racingcar.controller;

import racingcar.model.GameSettingsDto;

public class GameManager {
    private GameSettingsDto gameSettingsDto;

    private UserInput userInput;
    private RacingGame racingGame;

    public GameManager(){
        userInput = new UserInput();
        racingGame = new RacingGame();
    }

    public void startGame(){
        gameSettingsDto = userInput.readUserGameSettingInput();
        racingGame.runRaceIterations(gameSettingsDto);
    }
}
