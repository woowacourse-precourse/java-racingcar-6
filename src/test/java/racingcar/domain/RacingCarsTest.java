package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    @DisplayName("경주용 자동차가 저장되는지 확인")
    @Test
    void createCarsTest() {
        List<String> cars = Arrays.asList("abcd", "qwer");
        RacingCars racingCars = new RacingCars(cars);
        Iterator<Car> nowCars = racingCars.getCars().iterator();
        assertThat(nowCars.next().getName()).isEqualTo("abcd");
        assertThat(nowCars.next().getName()).isEqualTo("qwer");
    }

    @DisplayName("경주용 자동차 이름 예외발생")
    @Test
    void createCarsFalseTest() {
        List<String> cars = Arrays.asList("abcd", "qwertq");
        assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }


}