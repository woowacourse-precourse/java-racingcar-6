package racingcar.service;

import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.repository.CarRepository;

public class RacingService {
    private final CarRepository carRepository;
    private int currentRound;

    public RacingService(CarsDto carsDto, Client client) {
        this.carRepository = new CarRepository(carsDto, client);
        currentRound = 0;
    }

    public ResultDto playCarRacing() {
        while (!carRepository.isFinalRound()) {
            currentRound++;
            carRepository.race(currentRound);
        }
        return carRepository.finishFinalRound();
    }
}