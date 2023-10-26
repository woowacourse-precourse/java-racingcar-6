package racingcar.domain;


import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String SPLIT_STRING = ",";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carNames) {

        return new Cars(Arrays.stream(carNames.split(SPLIT_STRING))
                .map(Car::from)
                .toList());

    }

    public void go() {
        cars.forEach(Car::go);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinnerNameList() {
        Integer maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private Integer findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 최대 위치를 찾을 수 없습니다."));
    }
}
