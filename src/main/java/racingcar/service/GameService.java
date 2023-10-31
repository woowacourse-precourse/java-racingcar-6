package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameService {
    private static final int START_POSITION = 0;
    private static final int END_POSITION = 9;

    private int getRandomDistance() {
        return Randoms.pickNumberInRange(START_POSITION, END_POSITION);
    }
}
