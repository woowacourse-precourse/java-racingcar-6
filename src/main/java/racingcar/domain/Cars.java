package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        carList = carNames.stream().map(Car::new).toList();
    }

    public void run() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return carList;
    }
}
