package racingcar.service;

import java.util.List;
import racingcar.view.CarListRequest;

public class Service {

    private final Race race;

    public Service() {
        this.race = new Race();
    }

    public void registerCar(CarListRequest carListRequest) {
        List<String> carNames = carListRequest.carNames();
        List<Car> newCarList = carNames.stream().map(
            Car::toEntity
        ).toList();
        race.registerCars(newCarList);
    }

    public void playRaceRoutine(Integer numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            race.playRace();
            race.printCurrentStatus();
        }
    }

    public List<Car> getResult() {
        return race.getWinners();
    }
}
