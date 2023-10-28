package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RaceService {
    public List<Car> getWinner(List<Car> cars) {
        int highestLocation = cars.stream().mapToInt(Car::getLocation).max().getAsInt();
        return cars.stream().filter(car -> car.getLocation() == highestLocation).collect(Collectors.toList());
    }

    public void runRace(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.goOrStop(randomNumber);
        }
    }

    public void runRaceWithIteration(List<Car> cars, int iteration) {
        for (int i = 0; i < iteration; i++) {
            runRace(cars);
        }
    }
}
