package racingcar.service;

import racingcar.controller.MessageDto;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.wrapper.RaceRound;

public class RaceService {
    private final RefereeService refereeService;

    public RaceService() {
        refereeService = new RefereeService();
    }

    public Cars createCars(String carNames) {
        return Cars.create(carNames);
    }

    public RaceRound createRaceRound(String numberOfRound) {
        return RaceRound.create(numberOfRound);
    }

    public Race createRace(Cars cars, RaceRound raceRound) {
        return Race.create(cars, raceRound);
    }

    public MessageDto proceedRace(Race race) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < race.getRaceRound().getNumberOfRound(); ++i) {
            race.roundStart();
            String roundResult = refereeService.getRoundResult(race.getCars());
            builder.append(roundResult);
        }
        return new MessageDto(builder.toString());
    }
}
