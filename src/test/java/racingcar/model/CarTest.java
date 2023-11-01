package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.mock.TestNumberGenerator;
import racingcar.model.car.Car;
import racingcar.model.car.CarDTO;

class CarTest {
    @Nested
    class moveOneStepTest {
        @Test
        void 전진_테스트() {
            // given
            Car car = new Car("name", new TestNumberGenerator(5));

            // when
            car.moveOneStep();

            // then
            assertThat(car.getStep()).isEqualTo(1);
        }

        @Test
        void 전진_안함_테스트() {
            // given
            Car car = new Car("name", new TestNumberGenerator(3));

            // when
            car.moveOneStep();

            // then
            assertThat(car.getStep()).isEqualTo(0);
        }
    }

    @Nested
    class toCarDTOTest {
        @Test
        void CarDTO_변환_테스트() {
            // given
            Car car = new Car("name", new TestNumberGenerator(5));

            // when
            CarDTO carDTO = car.toCarDTO();

            // then
            assertThat(carDTO.name()).isEqualTo("name");
            assertThat(carDTO.step()).isEqualTo(0);
        }
    }


    @Nested
    class compareTest {
        @Test
        void 전진_횟수_비교_참_테스트() {
            // given
            Car car = new Car("name", new TestNumberGenerator(5));

            // when
            boolean isSame = car.compare(0);

            // then
            assertThat(isSame).isTrue();
        }

        @Test
        void 전진_횟수_비교_거짓_테스트() {
            // given
            Car car = new Car("테스트차", new TestNumberGenerator(5));

            // when
            boolean isSame = car.compare(1);

            // then
            assertThat(isSame).isFalse();
        }
    }

    @Nested
    class createCarTest {
        @Test
        void 이름_길이가_5_초과할때_에러_발생() {
            assertThatThrownBy(() -> new Car("LongName", new TestNumberGenerator(5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5자 이하여야 합니다.");
        }
    }


}