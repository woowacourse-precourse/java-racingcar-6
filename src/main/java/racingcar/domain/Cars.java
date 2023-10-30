package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int START_INCLUSION_NUMBER = 0;
    private static final int END_INCLUSION_NUMBER = 9;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> cars) {
        return new Cars(
                cars.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public void drawNumber() {
        for (Car car : this.cars) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSION_NUMBER, END_INCLUSION_NUMBER);
            car.accumulate(randomNumber);
        }
    }

    public List<Car> getCarList() {return this.cars;}

    public Winners getWinnerList() {
        return Winners.of(this);
    }
}
