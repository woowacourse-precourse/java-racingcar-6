package racingcar.service;

import racingcar.domain.Cars;

public class GameService {

    public Cars createCars(final String names) {
        return new Cars(names);
    }

}
