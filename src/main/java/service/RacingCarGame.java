package service;

import camp.nextstep.edu.missionutils.Console;
import view.InputPhrase;

public class RacingCarGame {
    IllegalLogic illegalLogic = new IllegalLogic();

    InputPhrase inputPhrase = new InputPhrase();
    public void run(){
        inputPhrase.startInputMessage();
        illegalLogic.processingIllegalLogic(Console.readLine());
        gameStart();
    }

    private void gameStart(){
        inputPhrase.inputNumberAttempts();
        illegalLogic.checkInputNumberAttempts(Console.readLine());
    }
}
