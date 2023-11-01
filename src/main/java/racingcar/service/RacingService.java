package racingcar.service;

import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.repository.CarRepository;

public class RacingService {
    private final CarRepository carRepository;

    public RacingService(CarsDto carsDto, Client client) {
        this.carRepository = new CarRepository(carsDto, client);
    }

    public ResultDto playCarRacing() {
        while (!carRepository.isFinalRound()) {
            carRepository.race();
        }
        return carRepository.finishFinalRound();
    }
}