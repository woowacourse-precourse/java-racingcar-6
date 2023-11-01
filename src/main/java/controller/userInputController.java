package controller;

import static model.utilityModel.splitByComma;
import static model.utilityModel.stringToInt;
import static view.guideMessage.PLEASE_INPUT_RACINGCAR_NAMES;
import static view.guideMessage.PLEASE_INPUT_RACING_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class userInputController {
    public String[] getRaceCarNames(){
        System.out.println(PLEASE_INPUT_RACINGCAR_NAMES);
        String userInput = Console.readLine();
        return splitByComma(userInput);
    }
    public int getAttemptCount(){
        System.out.println(PLEASE_INPUT_RACING_COUNT);
        String userInput = Console.readLine();
        return stringToInt(userInput);
    }
}