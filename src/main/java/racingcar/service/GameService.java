package racingcar.service;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.dto.RoundResultDto;
import racingcar.util.TrialCountValidator;

public class GameService {

    public Cars createCars(final String names) {
        return new Cars(names);
    }

    public int createTrialCount(final String trialCount) {
        TrialCountValidator.validate(trialCount);
        return Integer.parseInt(trialCount);
    }

    public void moveCars(final Cars cars) {
        cars.moveEachCar();
    }

    public RoundResultDto getRoundResult(final Cars cars) {
        return cars.toRoundResultDto();
    }

    public List<String> findWinnersName(final Cars cars) {
        return cars.findWinnersName();
    }

}
