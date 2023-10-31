package racingcar.domain;

import static racingcar.constant.NumberConst.MAX_RANDOM_NUMBER;
import static racingcar.constant.NumberConst.MIN_RANDOM_NUMBER;
import static racingcar.constant.NumberConst.STANDARD_MOVING_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.util.ConvertUtil;

public class CarGame {

    private List<Car> cars;

    public CarGame(String carNames) {
        cars = ConvertUtil.convertStrToListCar(carNames);
    }

    public void movePosition() {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (randomNum >= STANDARD_MOVING_NUMBER) {
                car.addPosition();
            }
        }
    }

    public List<Car> findWinner() {
        return cars.stream().filter(car -> car.getPosition() == findMaxPosition()).toList();
    }

    private int findMaxPosition() {
        return cars.stream().map(Car::getPosition).max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return cars;
    }

}
