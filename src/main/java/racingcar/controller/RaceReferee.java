package racingcar.controller;

import racingcar.model.Racer;

public class RaceReferee {
    public static Racer increaseGoMark(Racer racer) {
        if (racer.getState()) {
            racer.moveState += "-";
        }
        return racer;
    }
}