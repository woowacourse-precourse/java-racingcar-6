package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static void add(Car car) {
        cars.add(car);
    }

    public static Car findCarByName(String name) {
        return cars.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 된 자동차를 찾을 수 없습니다."));
    }
}
