package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.GameSettingsDto;
import racingcar.model.WinnerDto;

import java.util.List;

public class GameManager {
    private GameSettingsDto gameSettingsDto;
    private List<CarDto> carInformationList;
    private WinnerDto winnerDto;

    private UserInput userInput;
    private RacingGame racingGame;
    private Judgement judgement;

    public GameManager(){
        userInput = new UserInput();
        racingGame = new RacingGame();
        judgement = new Judgement();
    }

    public void startGame(){
        gameSettingsDto = userInput.readUserGameSettingInput();
        carInformationList = racingGame.runRaceIterations(gameSettingsDto);
        winnerDto = judgement.judgeWinner(carInformationList);
    }
}
