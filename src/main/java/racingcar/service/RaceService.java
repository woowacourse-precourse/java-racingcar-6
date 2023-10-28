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


}
