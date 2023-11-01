package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.numberpicker.RandomNumberPicker;
import racingcar.mock.FakeRandomNumberPicker;

class CarTest {

    @DisplayName("차를 처음 생성 시 전진 카운트는 0이다.")
    @Test
    void init() {
        // when
        Car car = Car.nameOf(CarName.from("haero"));

        // then
        assertThat(car.getForwardCount()).isEqualTo(0L);
    }

    @DisplayName("선택된 난수가 4~9 사이의 숫자라면 차는 한 칸 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveForwardForNumberGreaterThanOrEqualTo4(int randomDigit) {
        // given
        RandomNumberPicker randomNumberPicker = new FakeRandomNumberPicker(randomDigit);

        Car car = Car.nameOf(CarName.from("haero"));

        // when
        car.moveForward(randomNumberPicker);

        // then
        assertThat(car.getForwardCount()).isEqualTo(1L);
    }

    @DisplayName("선택된 난수가 0~3 사이의 숫자라면 차는 전진 하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveForwardForNumberLessThan4(int randomDigit) {
        // given
        RandomNumberPicker randomNumberPicker = new FakeRandomNumberPicker(randomDigit);

        Car car = Car.nameOf(CarName.from("haero"));

        // when
        car.moveForward(randomNumberPicker);

        // then
        assertThat(car.getForwardCount()).isEqualTo(0L);
    }

}
