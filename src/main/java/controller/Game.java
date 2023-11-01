package controller;

import java.awt.SystemTray;
import java.util.ArrayList;
import view.GuideMessage;
import model.utilityModel;
import model.racingGameModel;
public class Game{
    public void gameStart(){
        GuideMessage guideMessage = new GuideMessage();
        UserInputController userInputController = new UserInputController();
        utilityModel utilityModel = new utilityModel();
        racingGameModel racingGameModel = new racingGameModel();

        System.out.println(guideMessage.PLEASE_INPUT_RACINGCAR_NAMES);
        String userInputCarNames = userInputController.inputCarNames();

        String[] carNamesArray = utilityModel.splitByComma(userInputCarNames);
        racingGameModel.racingCarNames.addAll(racingGameModel.listUpRacingCar(carNamesArray));
    }
}