package racingcar.domain;

import static racingcar.constant.Constant.*;

import java.util.List;

import racingcar.controller.RaceController;
import racingcar.view.Input;

public class RacingGame {

    private Input input;
    private Integer playTime;
    private RaceController raceController;

    public RacingGame() {
        input = new Input();
    }

    public void run() {
        readyRacingGame();
        while (isRemainPlayTime()){
            raceController.round();

        }
        raceController.gameOver();
        input.close();
    }

    private boolean isRemainPlayTime(){
        return playTime-- != ZERO ;
    }

    private void readyRacingGame(){
        input.printGameStartMessage();
        List<String> racingCarNames = input.writeCarNames();
        input.printPlayTimeQuestion();
        playTime = input.writePlayTime();
        raceController = new RaceController(racingCarNames);
    }
}
