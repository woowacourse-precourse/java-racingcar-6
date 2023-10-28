package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class RaceService {
    public void runRace(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            car.goOrStop(randomNumber);
        }
    }

    public void runRaceWithIteration(List<Car> cars, int iteration) {
        for (int i = 0; i < iteration; i++) {
            runRace(cars);
        }
    }
}
