package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarEngine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차는 처음 생성될 때 현 위치는 0이다")
    void car_construct_test() {
        // given
        String name = "pobi";
        CarEngine engine = () -> true;

        // when
        Car car = new Car(name, engine);

        // then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 경우 IllegalArgumentException을 반환한다")
    void car_construct_with_5length_over_name() {
        // given
        String name = "name-with-longer-than-5-length";
        CarEngine engine = () -> true;

        // when & then
        assertThatThrownBy(() -> new Car(name, engine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }

    @Nested
    @DisplayName("자동차의 move 메소드는")
    class CarMoveTest {
        @Test
        @DisplayName("자신의 엔진의 실행 결과가 true면 현 위치를 1 증가시킨다")
        void car_move_test() {
            // given
            CarEngine engine = () -> true;

            // when
            Car car = new Car("pobi", engine);
            car.move();

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("자신의 엔진의 실행 결과가 false면 현 위치를 증가시키지 않는다")
        void car_move_test_with_false_engine_result() {
            // given
            CarEngine engine = () -> false;

            // when
            Car car = new Car("pobi", engine);
            car.move();

            // then
            assertThat(car.getPosition()).isZero();
        }
    }

}
