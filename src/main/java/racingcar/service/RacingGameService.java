package racingcar.service;

import java.util.ArrayList;
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
        List<RoundResultDto> roundHistories = executeAllRounds(participants, roundCount);
        List<CarStatusDto> carsStatusAtRaceEnd = getRaceEndStatus(participants);
        return refereeService.publishGameResult(roundHistories, carsStatusAtRaceEnd);
    }

    private static List<CarStatusDto> getRaceEndStatus(List<Car> participants) {
        return participants.stream()
                .map(CarStatusDto::createFrom)
                .toList();
    }

    private List<RoundResultDto> executeAllRounds(List<Car> participants, RoundCount roundCount) {
        List<RoundResultDto> roundHistories = new ArrayList<>();
        while (roundCount.hasNextRound()) {
            RoundResultDto roundResultDto = refereeService.executeRound(participants);
            roundHistories.add(roundResultDto);
            roundCount.consumeRound();
        }
        return roundHistories;
    }

}
