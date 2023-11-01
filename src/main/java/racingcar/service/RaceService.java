package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Race;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;

public class RaceService {
    
    private final CarService carService;

    public RaceService(final CarService carService) {
        this.carService = carService;
    }

    public Race createRace(final String raceCount) {
        return Race.create(raceCount);
    }

    public List<RaceResultDto> getRaceResults(final Cars cars, final Race race) {
        List<RaceResultDto> raceResults = new ArrayList<>();
        int raceCount = 0;

        while (race.isRunning(raceCount++)) {
            startRace(cars);
            RaceResultDto raceResult = getRaceResults(cars);
            raceResults.add(raceResult);
        }
        return raceResults;
    }

    private void startRace(final Cars cars) {
        cars.race();
    }

    private RaceResultDto getRaceResults(final Cars cars) {
        List<CarStatusDto> carRaceResult = carService.getCarStatus(cars);
        return RaceResultDto.create(carRaceResult);
    }
}
