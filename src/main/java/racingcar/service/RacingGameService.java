package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class RacingGameService {

    private final RefereeService refereeService;

    public RacingGameService(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    public GameResultDto run(List<CarName> carNames, RoundCount roundCount) {
        List<Car> participants = prepareRacingCars(carNames);
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

    private List<Car> prepareRacingCars(List<CarName> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, new Position(0), new DefaultPowerGenerator()))
                .collect(Collectors.toList());
    }

}
