package controller;

import java.awt.SystemTray;
import view.GuideMessage;
public class Game{
    public void gameStart(){
        GuideMessage guideMessage = new GuideMessage();
        UserInputController userInputController = new UserInputController();

        System.out.println(guideMessage.PLEASE_INPUT_RACINGCAR_NAMES);
        String racingCarNames = userInputController.inputCarNames();

        System.out.println(racingCarNames);
    }
}