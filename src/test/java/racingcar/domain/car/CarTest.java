package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.formula.MockFormula;
import racingcar.domain.formula.MoveState;

public class CarTest {

    @Nested
    @DisplayName("자동차를 생성할 때")
    public class CreateNewCarTest {

        @Test
        @DisplayName("이름과 위치를 지정하면 지정한 이름과 위치로 생성된다.")
        void 이름과_위치를_지정하면_지정한_이름과_위치로_생성된다() {
            // given
            var name = "pobi";
            var position = 0;

            // when
            var car = new Car(name, position);

            // then
            assertThat(car).isNotNull();
            assertThat(car.getName()).isEqualTo(name);
        }

        @Test
        @DisplayName("이름이 빈 문자열이면 예외를 반환한다.")
        void 이름이_빈_문자열이면_예외를_반환한다() {
            // given
            var name = "";
            var position = 0;

            // when & then
            assertThatThrownBy(() -> new Car(name, position))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 1자 이상 5자 이하만 가능합니다.");
        }

        @Test
        @DisplayName("이름이 5자를 초과하면 예외를 반환한다.")
        void 이름이_5자를_초과하면_예외를_반환한다() {
            // given
            var name = "pobicon";
            var position = 0;

            // when & then
            assertThatThrownBy(() -> new Car(name, position))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 1자 이상 5자 이하만 가능합니다.");
        }

        @Test
        @DisplayName("위치가 0 미만이면 예외를 반환한다.")
        void 위치가_0_미만이면_예외를_반환한다() {
            // given
            var name = "pobi";
            var position = -1;

            // when & then
            assertThatThrownBy(() -> new Car(name, position))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("위치는 0 이상만 가능합니다.");
        }
    }

    @Nested
    @DisplayName("자동차 전진 또는 멈춤 여부를 판단할 때")
    public class CarMoveTest {

        private final String name = "pobi";
        private final int position = 0;

        @Test
        @DisplayName("MoveState가 MOVING_FORWARD일 때 전진한다.")
        void MoveState가_MOVING_FORWARD일_때_전진한다() {
            // given
            var car = new Car(name, position);
            var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);

            // when
            var actual = car.move(mockFormula);

            // then
            assertThat(actual).isEqualTo(position + 1);
        }

        @Test
        @DisplayName("MoveState가 STOP일 때 멈춘다.")
        void MoveState가_STOP일_때_멈춘다() {
            // given
            var car = new Car(name, position);
            var mockFormula = new MockFormula(MoveState.STOP);

            // when
            var actual = car.move(mockFormula);

            // then
            assertThat(actual).isEqualTo(position);
        }
    }

    @Nested
    @DisplayName("자동차의 정보를 가져올 때")
    public class GetCarInfoTest {

        @Test
        @DisplayName("이름을 반환한다.")
        void 이름을_반환한다() {
            // given
            var name = "pobi";
            var car = new Car(name, 0);

            // when
            var actual = car.getName();

            // then
            assertThat(actual).isEqualTo(name);
        }

        @Test
        @DisplayName("두 자동차의 위치가 같으면 true를 반환한다.")
        void 두_자동차의_위치가_같으면_true를_반환한다() {
            // given
            var car = new Car("pobi", 1);
            var other = new Car("woni", 1);

            // when
            var actual = car.isSamePosition(other);

            // then
            assertThat(actual).isTrue();
        }

        @Test
        @DisplayName("두 자동차의 위치가 다르면 false를 반환한다.")
        void 두_자동차의_위치가_다르면_false를_반환한다() {
            // given
            var car = new Car("pobi", 2);
            var other = new Car("woni", 1);

            // when
            var actual = car.isSamePosition(other);

            // then
            assertThat(actual).isFalse();
        }

        @Test
        @DisplayName("두 자동차의 위치 간 차이를 반환한다.")
        void 두_자동차의_위치_간_차이를_반환한다() {
            // given
            var car = new Car("pobi", 2);
            var other = new Car("woni", 1);

            // when
            var actual = car.compareTo(other);

            // then
            assertThat(actual).isEqualTo(1);
        }
    }
}
