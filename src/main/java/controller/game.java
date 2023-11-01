package controller;

import static view.guideMessage.PLEASE_INPUT_RACINGCAR_NAMES;
import static model.utilityModel.splitByComma;
import model.racingGameModel;
public class game {
    public void gameStart(){
        userInputController userInputController = new userInputController();
        racingGameModel racingGameModel = new racingGameModel();

        System.out.println(PLEASE_INPUT_RACINGCAR_NAMES);
        String userInputCarNames = userInputController.inputCarNames();

        String[] carNamesArray = splitByComma(userInputCarNames);
        racingGameModel.racingCarNames.addAll(racingGameModel.listUpRacingCar(carNamesArray));
    }
}