package racingcar.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import racingcar.domain.service.RandomMoveJudge;

public record Cars(List<Car> cars) {

    public Cars(String input) {
        this(Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

        validateCarNames();
    }

    private void validateCarNames() {
        Pattern nameRegex = Pattern.compile("^[^,]{1,5}$");
        cars.stream()
                .filter(car -> !nameRegex.matcher(car.getName()).matches())
                .findFirst()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("1~5글자 사이의 문자열만 가능합니다.");
                });
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveAll(RandomMoveJudge moveJudge) {
        cars.stream().filter(car -> moveJudge.canMove()).forEach(Car::move);
    }

    public List<String> progressStatusFormat() {
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



