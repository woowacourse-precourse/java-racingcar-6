package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("Cars 생성 성공 테스트")
    @Test
    void createCarsSuccessTest() {
        List<CarName> carNames = Stream.of("a", "b", "c")
                .map(CarName::new)
                .toList();

        Cars cars = Cars.createByNames(carNames);

        assertThat(cars).isNotNull();
    }

    @DisplayName("Cars 생성 실패 테스트 - 중복")
    @Test
    void createCarsFailTest_1() {
        List<CarName> carNames = Stream.of("a", "a", "c")
                .map(CarName::new)
                .toList();

        assertThrows(IllegalArgumentException.class, () -> Cars.createByNames(carNames));
    }

    @DisplayName("Cars 생성 실패 테스트 - 공백")
    @Test
    void createCarsFailTest_2() {
        List<CarName> carNames = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> Cars.createByNames(carNames));
    }
}