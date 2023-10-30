package racingcar.service;

import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.RacingCars;

public class RacingService {
    RacingCars racingCars;
    Client client;

    public RacingService(CarsDto carsDto, Client client) {
        this.racingCars = new RacingCars(carsDto);
        this.client = client;
    }
}
