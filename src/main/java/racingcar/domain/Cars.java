package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream().map(Car::new).toList();
    }

    public void run() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
