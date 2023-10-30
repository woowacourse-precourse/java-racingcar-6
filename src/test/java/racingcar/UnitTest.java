package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UnitTest {

    private final Computer computer = new Computer();

    @Nested
    @DisplayName("사용자는 경주에 참여할 자동차 이름을 입력한다.")
    class CarNameInputTest {

        @Test
        void 이름은_1자_이상이다() {
            assertDoesNotThrow(() -> computer.readCarNames("green"));
        }

        @Test
        void 이름은_5자_이하이다() {
            assertDoesNotThrow(() -> computer.readCarNames("green"));
        }

        @Test
        void 이름이_6자_이상일경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green2"));
        }

        @Test
        void 이름이_공백만으로_구성될경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("   "));
        }

        @Test
        void 이름이_중복될경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green, green"));
        }

        @Test
        void 양쪽_공백은_제거된다() {
            assertDoesNotThrow(() -> computer.readCarNames(" green "));
        }

        @Test
        void 이름이_없을경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green,, red"));
        }
    }

    @Nested
    @DisplayName("사용자는 자동차 이동을 시도할 횟수를 입력한다.")
    class AttemptCountInputTest {

        @Test
        void 시도횟수는_0이상이다() {
            assertDoesNotThrow(() -> computer.readAttemptCount("0"));
        }

        @Test
        void 시도횟수가_음수이면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readAttemptCount("-1"));
        }

        @Test
        void 시도횟수가_숫자가_아니면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readAttemptCount("a"));
        }

        @Test
        void 시도횟수가_정수가_아니면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readAttemptCount("1.1"));
        }
    }
}
