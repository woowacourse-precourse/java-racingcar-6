package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Race;

public class RacingService {
    private final CarRepository carRepository;
    private Race race;

    public RacingService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void prepareRace(final List<String> carNames, final int numberOfRace) {
        for (String name : carNames) {
            carRepository.save(Car.from(name));
        }
        race = Race.from(numberOfRace);
    }

    public final List<CarDto> runSingleRace() {
        race.runSingleRace(carRepository.getCars());
        return carRepository.getCars().stream()
                .map(car -> CarDto.from(car))
                .toList();
    }

    public final boolean isRunning() {
        return race.isRunning();
    }


    public final List<String> getWinner() {
        return carRepository.getWinner();
    }
}
