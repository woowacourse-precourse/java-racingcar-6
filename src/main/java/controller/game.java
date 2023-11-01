package controller;

import static view.guideMessage.PLEASE_INPUT_RACINGCAR_NAMES;
import static view.guideMessage.PLEASE_INPUT_RACING_COUNT;
import static model.utilityModel.splitByComma;
import static model.utilityModel.stringToInt;
import static model.utilityModel.stringArrayToStringArrayList;

import model.racingGameModel;

import java.util.ArrayList;

public class game {
    public void gameStart(){
        userInputController userInputController = new userInputController();
        //경주할 자동차 이름 입력
        System.out.println(PLEASE_INPUT_RACINGCAR_NAMES);
        String userInput = userInputController.userInput();
        String[] carNamesArray = splitByComma(userInput);
        ArrayList<String> inputRacingCarNames = stringArrayToStringArrayList(carNamesArray);
        //시도 횟수 입력
        System.out.println(PLEASE_INPUT_RACING_COUNT);
        userInput = userInputController.userInput();
        int inputRacingCount = stringToInt(userInput);
        //racingGameModel class 인스턴스 초기화
        racingGameModel racingGameModel = new racingGameModel(inputRacingCarNames,inputRacingCount);
    }
}