package controller;

import static model.UtilityModel.isInValidNames;
import static model.UtilityModel.splitByComma;
import static model.UtilityModel.stringToInt;
import static view.GuideMessage.PLEASE_INPUT_RACINGCAR_NAMES;
import static view.GuideMessage.PLEASE_INPUT_RACING_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String[] getRaceCarNames() {
        System.out.println(PLEASE_INPUT_RACINGCAR_NAMES);
        String userInput = Console.readLine();
        String[] carNamesArray = splitByComma(userInput);
        isInValidNames(carNamesArray);
        return carNamesArray;
    }

    public int getAttemptCount() {
        System.out.println(PLEASE_INPUT_RACING_COUNT);
        String userInput = Console.readLine();
        return stringToInt(userInput);
    }
}