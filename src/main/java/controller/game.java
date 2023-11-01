package controller;

import static view.guideMessage.PLEASE_INPUT_RACINGCAR_NAMES;
import static view.guideMessage.PLEASE_INPUT_RACING_COUNT;
import static model.utilityModel.splitByComma;
import static model.utilityModel.stringToInt;

import model.racingGameModel;
public class game {
    public void gameStart(){
        userInputController userInputController = new userInputController();
        racingGameModel racingGameModel = new racingGameModel();
        //경주할 자동차 이름 입력
        System.out.println(PLEASE_INPUT_RACINGCAR_NAMES);
        String userInputCarNames = userInputController.userInput();
        String[] carNamesArray = splitByComma(userInputCarNames);
        racingGameModel.racingCarNames.addAll(racingGameModel.listUpRacingCar(carNamesArray));
        //시도 횟수 입력
        System.out.println(PLEASE_INPUT_RACING_COUNT);
        String userInputRacingCount = userInputController.userInput();
        racingGameModel.racingCount = stringToInt(userInputRacingCount);
    }
}