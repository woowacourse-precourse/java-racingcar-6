package racingcar.controller;

import racingcar.service.RacingReferee;
import racingcar.view.RacingView;

public class RacingController {
    // 레이싱 게임을 관리하는 컨트롤러
    private RacingReferee racingReferee;

    public RacingController(RacingReferee racingReferee) {
        this.racingReferee = racingReferee;
    }

    public RacingView play() {
        racingReferee.race();
        return null;
    }

    public RacingView end() {
        return null;
    }
}
