package racingcar.controller;

import racingcar.model.Racer;

public class RaceReferee {
    public static Racer increaseGoMark(Racer racer) {
        int moveCount = racer.getMoveCount();
        for (int count = 0; count < moveCount; count++) {
            racer.moveState += "-";
        }
        return racer;
    }
}
