package racingcar.model;

import java.util.List;
import racingcar.repository.Track;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNumberOfCars(cars);
        validateDistinctName(cars);
        this.cars = cars;
    }

    private void validateDistinctName(List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다.");
        }
    }

    private void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2개 이상의 자동차를 입력해주세요.");
        }
    }

    public void ready(Track track) {
        cars.forEach(track::stand);
    }

    public String run(Track track) {
        cars.forEach(car ->
            track.move(car, RandomNumberGenerator.generateNumber())
        );
        return track.toString();
    }
}
