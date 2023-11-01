package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;

public class GameService {

    private static final int MIN_MOVE_NUMBER = 0;
    private static final int MAX_MOVE_NUMBER = 9;


    public void moveCars(Cars cars) {

        cars.value().forEach(car -> car.tryMove(makeRandomNumberForMove()));
    }

    private int makeRandomNumberForMove() {

        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }
}
