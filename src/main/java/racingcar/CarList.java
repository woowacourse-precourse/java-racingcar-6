package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarList {

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }


    public void continueGame() {
        cars.stream().forEach(car -> {
            if (Randoms.pickNumberInRange(Constant.NUMBER_RANGE_INCLUDE, Constant.NUMBER_RANGE_EXCLUDE) >= 4) {
                car.plusCurrentPlace();
            }
        });
    }


    public List<Car> getCars() {
        return this.cars;
    }

}
