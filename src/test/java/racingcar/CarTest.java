package racingcar;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    static class TestMoveStrategy implements MoveStrategy {
        private boolean movable;

        public TestMoveStrategy(boolean movable) {
            this.movable = movable;
        }

        public void setMovable(boolean movable) {
            this.movable = movable;
        }

        @Override
        public boolean determineMovable() {
            return movable;
        }
    }

    @Nested
    class CreateCar {
        @Test
        void 자동차_생성된다() {
            assertThatNoException()
                    .isThrownBy(() -> new Car("자동차이름"));
        }

        @Test
        void 자동차_이름이_null이면_예외발생() {
            assertThatThrownBy(() -> new Car(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_이름이_빈_문자열이면_예외발생() {
            assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_이름이_5글자_초과하면_예외발생() {
            assertThatThrownBy(() -> new Car("다섯글자가넘는이름"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class MoveCar {
        @Test
        void 자동차_이동전략이_전진가능이면_자동차가_1만큼_전진한다() {
            Car car = new Car("자동차이름", new TestMoveStrategy(true));
            car.move();

            assertThat(car.getPosition())
                    .isEqualTo(1);
        }

        @Test
        void 자동차_이동전략이_전진불가면_자동차가_정지한다() {
            Car car = new Car("자동차이름", new TestMoveStrategy(false));
            car.move();

            assertThat(car.getPosition())
                    .isZero();
        }
    }
}
