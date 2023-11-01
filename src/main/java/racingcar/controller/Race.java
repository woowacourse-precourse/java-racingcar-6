package racingcar.controller;

import racingcar.service.RaceSetting;

public class Race {
    RaceSetting raceSetting;

    public void start() {
        raceSetting = new RaceSetting();
        raceSetting.set();

    }
}
