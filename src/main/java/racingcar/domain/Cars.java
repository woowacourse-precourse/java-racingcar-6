package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.ParserUtils;

public class Cars {
    private ArrayList<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public ArrayList<Car> get() {
        return cars;
    }

    public void initializeCar(String carNamesInput) {
        List<String> carNames = ParserUtils.namesParser(carNamesInput);

        validateDuplicatedName(carNames);
        addCarsFromNames(carNames);
    }

    private void addCarsFromNames(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void validateDuplicatedName(List<String> carNames) {
        Set<String> carName = new HashSet<>(carNames);

        if (carName.size() != carNames.size()) {
            throw new IllegalArgumentException("이미 사용중인 자동차 이름입니다.");
        }
    }
}
