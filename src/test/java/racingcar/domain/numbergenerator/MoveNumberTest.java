package racingcar.domain.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingException;

class MoveNumberTest {

    @Nested
    @DisplayName("객체 생성 테스트")
    class 객체_생성_테스트 {

        @ParameterizedTest(name = "{0}은 정상적인 MoveNumber 입니다.")
        @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
        @DisplayName("[SUCCESS] 0~9 사이의 값   으로 정상적으로 객체가 생성된다.")
        void 정상_생성(int number) {
            assertThatNoException()
                    .isThrownBy(() -> new MoveNumber(number));
        }

        @ParameterizedTest(name = "{0}을 사용해 객체를 생성하면 예외가 발생한다.")
        @ValueSource(ints = {-1, 10, 49})
        @DisplayName("[EXCEPTION] 0~9 이외의 값으로는 객체 생성을 실패한다.")
        void 생성_실패(int number) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new MoveNumber(number))
                    .withMessage(RacingException.INVALID_NUMBERS.getMessage());
        }
    }

    @Nested
    @DisplayName("이동 테스트")
    class 이동_테스트 {

        @ParameterizedTest(name = "{0}의 값은 이동할 수 있는 숫자이다.")
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("[SUCCESS] 이동 가능 숫자 테스트")
        void 이동_가능_테스트(int number) {
            MoveNumber moveNumber = new MoveNumber(number);
            assertThat(moveNumber.canMove())
                    .isTrue();
        }

        @ParameterizedTest(name = "{0}의 값은 이동할 수 없는 숫자이다.")
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("[SUCCESS] 이동 불가능 숫자 테스트")
        void 이동_불가능_테스트(int number) {
            MoveNumber moveNumber = new MoveNumber(number);
            assertThat(moveNumber.canMove())
                    .isFalse();
        }
    }
}