package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("4 미만의 수가 나오면 이동하지 않는다.")
    void should_NotMove_When_LessThan4(int number) {
        Car car = new Car(new CarName("보라돌이"), new CarPosition(0));
        Car carAfter = car.move(number);
        assertThat(carAfter.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 수가 나오면 이동한다.")
    void should_Move_When_GreaterThanOrEqualTo4(int number) {
        Car car = new Car(new CarName("뚜비"), new CarPosition(0));
        Car carAfter = car.move(number);
        assertThat(carAfter.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 위치에 있는지 확인한다.")
    void should_True_When_SamePosition() {
        Car nana = new Car(new CarName("나나"), new CarPosition(4));
        Car ppo = new Car(new CarName("뽀"), new CarPosition(4));
        assertThat(nana.isSamePosition(ppo)).isTrue();
    }

    @Test
    @DisplayName("다른 위치에 있는지 확인한다.")
    void should_False_When_DifferentPosition() {
        Car nana = new Car(new CarName("나나"), new CarPosition(4));
        Car ppo = new Car(new CarName("뽀"), new CarPosition(5));
        assertThat(nana.isSamePosition(ppo)).isFalse();
    }

}
