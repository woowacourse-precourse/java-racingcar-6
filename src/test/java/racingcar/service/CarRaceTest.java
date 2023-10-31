package racingcar.service;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Numbers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRaceTest {

    List<Car> cars = Arrays.asList(
            new Car("pobi", ""),
            new Car("woni", ""),
            new Car("jun", "")
    );

    @Test
    @DisplayName("숫자가 4이상일 때 자동차가 전진하는지 테스트")
    public void moveForwardTest(){

        CarRace carRace = new CarRace(cars);

        List<String> originalPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        carRace.moveForward(Numbers.MOVE_POSITION_NUMBER.getNumber(), Numbers.RANDOM_END_NUMBER.getNumber());

        List<String> movedPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        assertThat(originalPosition).isNotEqualTo(movedPosition);
    }

    @Test
    @DisplayName("숫자가 3이하일 때 자동차가 전진하지 않는지 테스트")
    public void stayPositionTest() {
        CarRace carRace = new CarRace(cars);

        List<String> originalPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        carRace.moveForward(Numbers.RANDOM_START_NUMBER.getNumber(), Numbers.STAY_POSITION_NUMBER.getNumber());

        List<String> movedPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        assertThat(originalPosition).isEqualTo(movedPosition);
    }

}