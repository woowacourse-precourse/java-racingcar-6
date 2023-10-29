package service;

import camp.nextstep.edu.missionutils.Console;
import view.InputPhrase;

public class RacingCarGame {
    IllegalLogic illegalLogic = new IllegalLogic();
    RacingCarGameLogic racingCarGameLogic = new RacingCarGameLogic();

    InputPhrase inputPhrase = new InputPhrase();
    public void run(){
        inputPhrase.startInputMessage();
        illegalLogic.processingIllegalLogic(Console.readLine());
        gameStart();
    }

    private void gameStart(){
        inputPhrase.inputNumberAttempts();
        int repeteNumber = illegalLogic.checkInputNumberAttempts(Console.readLine());
        for(int i=0;i<repeteNumber;i++){
            racingCarGameLogic.checkFrontAttempts();
        }
    }
}
