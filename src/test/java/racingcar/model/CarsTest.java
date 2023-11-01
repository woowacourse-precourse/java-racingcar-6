package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private Cars cars;
    private final String inputNames = "isaac,han";

    private static final int MOVE_FORWARD = Common.STANDARD_NUMBER.getIntValue();
    private static final int STOP = Common.STANDARD_NUMBER.getIntValue() - 1;

    @BeforeEach
    @Test
    void init() {
        cars = new Cars(inputNames);

        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForwardByRandom();
            cars.everyCarMoveForwardByRandom();
        }, MOVE_FORWARD, MOVE_FORWARD, MOVE_FORWARD, MOVE_FORWARD);
    }

    @Test
    void everyCarMoveForwardByRandomTest() {
        Cars cars = new Cars(inputNames);

        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForwardByRandom();
            cars.everyCarMoveForwardByRandom();
            assertThat(cars.getCars().get(0).getDistance()).isEqualTo(2);
            assertThat(cars.getCars().get(1).getDistance()).isEqualTo(0);
        }, MOVE_FORWARD, STOP, MOVE_FORWARD, STOP);
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
