package racingcar.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.service.RandomMoveJudge;

public record Cars(List<Car> cars) {

    public Cars(String input) {
        this(Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveAll(RandomMoveJudge moveJudicator) {
        cars.stream().filter(car -> moveJudicator.canMove()).forEach(Car::move);
    }

    public List<String> progressStatusFormmat() {
        return cars.stream().map(Car::formattedProgress).collect(Collectors.toList());
    }

    public Cars findTopPositionCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(maxPosition))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::of));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Cars 객체에 Car가 존재하지 않습니다."));
    }

    public String formatNames() {
        return this.cars.stream().map(Car::getName).collect(Collectors.joining(","));
    }



}



