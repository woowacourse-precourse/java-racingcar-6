package racingcar.service;

import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class RacingGameService {

    private final GameResultPublishService gameResultPublishService;
    private final CarFactoryService carFactoryService;
    private final RoundExecutionService roundExecutionService;

    public RacingGameService(GameResultPublishService gameResultPublishService,
                             CarFactoryService carFactoryService,
                             RoundExecutionService roundExecutionService) {
        this.gameResultPublishService = gameResultPublishService;
        this.carFactoryService = carFactoryService;
        this.roundExecutionService = roundExecutionService;
    }

    public GameResultDto run(List<CarName> carNames, RoundCount roundCount) {
        List<Car> participants = carFactoryService.prepareRacingCars(carNames);
        List<RoundResultDto> roundHistories = roundExecutionService.executeAllRounds(participants, roundCount);
        List<CarStatusDto> carsStatusAtRaceEnd = getRaceEndStatus(participants);
        return gameResultPublishService.publishGameResult(roundHistories, carsStatusAtRaceEnd);
    }

    private static List<CarStatusDto> getRaceEndStatus(List<Car> participants) {
        return participants.stream()
                .map(CarStatusDto::createFrom)
                .toList();
    }


}
