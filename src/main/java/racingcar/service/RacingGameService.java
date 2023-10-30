package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.domain.Car;
import racingcar.service.domain.RacingCars;

public class RacingGameService {

    public OneGameResultsDto playOneTimeCarRace(RacingCars cars) {
        List<Car> endCars = cars.doRace();
        return new OneGameResultsDto(endCars);
    }

    public List<String> calculateFinalWinners(RacingCars racingCars) {
        List<Car> winners = racingCars.findWinners();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return winnerNames;
    }
}
