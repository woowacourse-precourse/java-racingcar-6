package racingcar.model;

import racingcar.JudgeWinner;

public class RacingGame {

    private final Cars cars;
    private final JudgeWinner judgeWinner;

    public RacingGame(Cars cars, JudgeWinner judgeWinner){
        this.cars = cars;
        this.judgeWinner = judgeWinner;
    }


}
