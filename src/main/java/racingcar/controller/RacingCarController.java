package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.RacingCarPrint;

public class RacingCarController {
    RacingCarService racingCarService = new RacingCarService();
    RacingCarPrint racingCarPrint = new RacingCarPrint();

    public void run(){
        setGame();
        playGame();
        endGame();
    }

    private void setGame(){
        racingCarService.setGame();
    }

    private void playGame(){
        racingCarService.playGame();
    }

    private void endGame(){
        racingCarPrint.printWinner(racingCarService.judgeWinner());
    }
}
