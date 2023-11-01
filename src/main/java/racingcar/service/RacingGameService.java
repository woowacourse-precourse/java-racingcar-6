package racingcar.service;

import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class RacingGameService {

    private final RefereeService refereeService;
    private final CarFactoryService carFactoryService;

    public RacingGameService(RefereeService refereeService, CarFactoryService carFactoryService) {
        this.refereeService = refereeService;
        this.carFactoryService = carFactoryService;
    }

    public GameResultDto run(List<CarName> carNames, RoundCount roundCount) {
        List<Car> participants = carFactoryService.prepareRacingCars(carNames);
        List<RoundResultDto> roundHistories = refereeService.executeAllRounds(participants, roundCount);
        List<CarStatusDto> carsStatusAtRaceEnd = getRaceEndStatus(participants);
        return refereeService.publishGameResult(roundHistories, carsStatusAtRaceEnd);
    }

    private static List<CarStatusDto> getRaceEndStatus(List<Car> participants) {
        return participants.stream()
                .map(CarStatusDto::createFrom)
                .toList();
    }


}
