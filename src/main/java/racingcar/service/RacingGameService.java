package racingcar.service;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.domain.Car;
import racingcar.service.domain.RacingCars;

public class RacingGameService {

    public OneGameResultsDto playOneTimeCarRace(RacingCars cars) {
        final List<Car> endCars = cars.doRace();
        return new OneGameResultsDto(endCars);
    }

    public List<String> calculateFinalWinners(RacingCars racingCars) {
        return racingCars.findWinners();
    }
}
