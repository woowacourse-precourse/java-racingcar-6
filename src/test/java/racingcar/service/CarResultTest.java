package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarResultTest {

    @Test
    @DisplayName("가장 많이 전진한 플레이어의 정보를 올바르게 가져오는지 테스트")
    public void mostMovedPlayer() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", "-"),
                new Car("woni", "---"),
                new Car("jun", "--")
        );

        String maxPosition = cars.stream()
                .map(car -> car.getPosition())
                .max(String::compareTo)
                .orElse("");

        List<String> maxPlayer = cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());

        Assertions.assertThat("---").isEqualTo(maxPosition);
        Assertions.assertThat("woni").contains(maxPlayer);
    }
}