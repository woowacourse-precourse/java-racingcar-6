package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumbers;

public interface RacingcarGameService {

    Cars generateCarsToRace(String inputMessage);

    void playOneRound(Cars cars, RandomNumbers randomNumbers);

}
