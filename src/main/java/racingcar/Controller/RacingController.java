package racingcar.Controller;

import racingcar.View.InputView;

public class RacingController {
    public void playRacing(){
        InputView.printAskCarName();
        //MoveRandomNumber.generateRandomGameNumber();

        WinnerController.judgeWin();

    }
}
