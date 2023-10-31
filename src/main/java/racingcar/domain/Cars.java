package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.CarResult;
import racingcar.domain.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = CarFactory.createCars(carNames);
    }

    public RoundResult race() {
        List<CarResult> carResultList = new ArrayList<>();
        for (Car car : cars) {
            carResultList.add(carMove(car));
        }
        return RoundResult.of(carResultList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    private CarResult carMove(Car car) {
        return car.move(Randoms.pickNumberInRange(0, 9));
    }
}
