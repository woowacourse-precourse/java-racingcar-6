package racingcar.service;

import racingcar.domain.*;
import racingcar.repository.CarRepository;

import java.math.BigInteger;

public class RacingService {
    private final CarRepository carRepository;
    private BigInteger currentRound;

    public RacingService(CarsDto carsDto, Client client) {
        this.carRepository = new CarRepository(carsDto, client);
        currentRound = BigInteger.ZERO;
    }

    public ResultDto playCarRacing() {
        while (!carRepository.isFinalRound()) {
            currentRound = currentRound.add(BigInteger.ONE);
            carRepository.race(currentRound);
        }
        return carRepository.finishFinalRound();
    }
}
