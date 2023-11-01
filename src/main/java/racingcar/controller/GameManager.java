package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.GameSettingsDto;

import java.util.List;

public class GameManager {
    private GameSettingsDto gameSettingsDto;
    private List<CarDto> carInformationList;

    private UserInput userInput;
    private RacingGame racingGame;

    public GameManager(){
        userInput = new UserInput();
        racingGame = new RacingGame();
    }

    public void startGame(){
        gameSettingsDto = userInput.readUserGameSettingInput();
        carInformationList = racingGame.runRaceIterations(gameSettingsDto);
    }
}
