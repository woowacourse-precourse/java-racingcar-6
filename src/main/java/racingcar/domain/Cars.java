package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.util.NumberGenerator;
import static racingcar.domain.constant.CarsConstant.SPLIT_DELIMITER;

public class Cars {
    
    private final List<Car> cars;

    private final NumberGenerator numberGenerator;

    private Cars(final String carNames, final NumberGenerator numberGenerator) {
        this.cars = create(carNames);
        this.numberGenerator = numberGenerator;
        validateDuplicateCarName();
    }
    
    public static Cars create(final String carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames, numberGenerator);
    }

    public void race() {
        cars.forEach(car -> {
            int power = numberGenerator.generate();
            car.move(power);
        });
    }

    public Car getMaxPositionCar() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }

    private List<Car> create(final String carNames) {
        String[] names = splitCarNames(carNames);
        return Arrays.stream(names)
        .map(Car::create)
        .collect(Collectors.toList());
    }

    private String[] splitCarNames(final String carNames) {
        return carNames.split(SPLIT_DELIMITER.getValue());
    }

    private void validateDuplicateCarName() {
        int uniqueCarCount = new HashSet<>(cars).size();
        if (cars.size() != uniqueCarCount) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    @Override
    public boolean equals(final Object diffCars) {
        if (this == diffCars) return true;
        if (diffCars == null || !(diffCars instanceof Cars)) return false;
        final Cars cars = (Cars) diffCars;
        return Objects.equals(this.cars, cars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }    
}
