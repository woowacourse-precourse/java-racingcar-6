package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static testutil.TestUtil.createCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 수가 나오면 이동하지 않는다.")
    void should_NotMove_When_LessThan4(int number) {
        Car car = createCar("보라돌이", 0);
        Car carAfter = car.move(number);
        assertThat(carAfter.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 수가 나오면 이동한다.")
    void should_Move_When_GreaterThanOrEqualTo4(int number) {
        Car car = createCar("뚜비", 0);
        Car carAfter = car.move(number);
        assertThat(carAfter.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 위치에 있는지 확인한다.")
    void should_True_When_SamePosition() {
        Car nana = createCar("나나", 4);
        Car ppo = createCar("뽀", 4);
        assertThat(nana.isSamePosition(ppo)).isTrue();
    }

    @Test
    @DisplayName("다른 위치에 있는지 확인한다.")
    void should_False_When_DifferentPosition() {
        Car nana = createCar("나나", 4);
        Car ppo = createCar("뽀", 5);
        assertThat(nana.isSamePosition(ppo)).isFalse();
    }

}
