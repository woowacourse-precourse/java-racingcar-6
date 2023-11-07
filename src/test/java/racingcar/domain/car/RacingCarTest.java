package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.FakeRandomNumberUtil;
import racingcar.util.RandomNumber;

class RacingCarTest {
        public static final String CAR_NAME = "ferrari";

        @Test
        @DisplayName("성공: 자동차는 이름을 반환")
        void call_getName_will_return_car_name() {
                //when
                RandomNumber util = new FakeRandomNumberUtil(1);
                Car racingCar = new RacingCar(CAR_NAME, util);
                String name = racingCar.getName();

                //then
                assertThat(name).isEqualTo(CAR_NAME);
        }

        @Test
        @DisplayName("성공: 자동차는 4이상의 숫자를 선택하면 1 만큼 전진")
        void call_move_drivenDistance_will_be_1() {
                //when
                RandomNumber util = new FakeRandomNumberUtil(4);
                Car racingCar = new RacingCar(CAR_NAME, util);
                racingCar.move();
                long drivenDistance = racingCar.getDrivenDistance();

                //then
                assertThat(drivenDistance).isEqualTo(1L);
        }

        @Test
        @DisplayName("성공: 자동차는 4미만의 숫자를 선택하면 정지")
        void call_move_drivenDistance_will_be_0() {
                //when
                RandomNumber util = new FakeRandomNumberUtil(3);
                Car racingCar = new RacingCar(CAR_NAME, util);
                racingCar.move();
                long drivenDistance = racingCar.getDrivenDistance();

                //then
                assertThat(drivenDistance).isEqualTo(0L);
        }
}
