package racingcar.controller;

import racingcar.service.RacingReferee;
import racingcar.view.RacingView;

public class RacingController {
    // 레이싱 게임을 관리하는 컨트롤러
    private RacingReferee racingReferee;

    private final Integer racingRound;


    public RacingController(RacingReferee racingReferee, Integer racingRound) {
        this.racingReferee = racingReferee;
        this.racingRound = racingRound;
    }

    public void play() {
        RacingView.viewPlay();

        for (int round = 0; round < racingRound; round++) {
            RacingView.viewRace(racingReferee.race());
        }
    }

    public void end() {
        RacingView.viewWinner(racingReferee.judge());
    }
}
