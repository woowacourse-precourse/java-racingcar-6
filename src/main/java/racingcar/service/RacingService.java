package racingcar.service;

import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;

public class RacingService {

    private final CarRepository carRepository;

    public RacingService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(final CarNamesDto carNames) {
        for(String name: carNames.getNames()) {
            carRepository.save(name);
        }
    }

}
