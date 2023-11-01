package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.Common;
import racingcar.testConstants.TestConstants;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private Cars cars;
    private final String inputNames = "isaac,han";

    @BeforeEach
    @Test
    void init() {
        cars = new Cars(inputNames);

        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForwardByRandom();
            cars.everyCarMoveForwardByRandom();
        }, TestConstants.MOVE_FORWARD, TestConstants.MOVE_FORWARD, TestConstants.MOVE_FORWARD, TestConstants.MOVE_FORWARD);
    }

    @Test
    void everyCarMoveForwardByRandomTest() {
        Cars cars = new Cars(inputNames);

        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForwardByRandom();
            cars.everyCarMoveForwardByRandom();
            assertThat(cars.getCars().get(0).getDistance()).isEqualTo(2);
            assertThat(cars.getCars().get(1).getDistance()).isEqualTo(0);
        }, TestConstants.MOVE_FORWARD, TestConstants.STOP, TestConstants.MOVE_FORWARD, TestConstants.STOP);
    }


    @Test
    void getCarsTest() {
        assertThat(cars.getCars().stream().allMatch(car -> car.getDistance() == 2)).isTrue();
        assertThat(cars.getCars().stream().map(car -> car.getName()).collect(Collectors.joining(","))).isEqualTo(inputNames);
    }

    @Test
    void getCarTest() {
        String searchName = "isaac";
        assertThat(cars.getCar(searchName).getName()).isEqualTo(searchName);
    }

    @Test
    void getCarExceptionTest() {
        String searchName = "isa";
        assertThatThrownBy(() -> cars.getCar(searchName).getName()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> cars.getCar(searchName).moveForwardByRandom()).isInstanceOf(IllegalArgumentException.class);
    }

}
