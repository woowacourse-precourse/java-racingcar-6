package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Generator;
import racingcar.model.Race;

public class RacingService {
    private CarRepository carRepository;
    private Generator generator;
    private Race race;

    public RacingService(CarRepository carRepository, Generator generator) {
        this.carRepository = carRepository;
        this.generator = generator;
    }

    public void prepareRace(List<String> carNames, int numberOfRace) {
        for (String name : carNames) {
            carRepository.save(Car.from(name));
        }
        race = Race.from(numberOfRace, generator);
    }

    public List<CarDto> runSingleRace() {
        race.runSingleRace(carRepository.getCars());
        return carRepository.getCars().stream()
                .map(car -> CarDto.from(car))
                .toList();
    }

    public boolean isRunning() {
        return race.isRunning();
    }


    public List<String> getWinner() {
        return carRepository.getWinner();
    }
}
