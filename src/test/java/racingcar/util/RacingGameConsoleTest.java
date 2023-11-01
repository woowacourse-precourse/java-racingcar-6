package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class RacingGameConsoleTest {
    @AfterEach
    void clearSystemIn() {
        RacingGameConsole.close();
    }

    @Test
    @DisplayName("입력 받은 이름들의 자동차 리스트를 반환할 수 있다.")
    void testReadRacingCars() {
        // given
        String input = "ann,bob,chris,doll";

        setSystemInput(input);

        // when
        List<RacingCar> racingCars = RacingGameConsole.readRacingCars();

        // then
        assertThat(racingCars.size()).isEqualTo(4);

        String joinedName = racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(","));

        assertThat(joinedName).isEqualTo(input);
    }

    @Nested
    @DisplayName("시도 횟수 입력 테스트")
    class TestReadEndLap {
        @Test
        @DisplayName("시도 횟수를 입력 받을 수 있다.")
        void success() {
            // given
            String input = "10";

            setSystemInput(input);

            // when
            int endLap = RacingGameConsole.readEndLap();

            // then
            int tryCount = Integer.parseInt(input);

            assertThat(endLap).isEqualTo(tryCount);
        }

        @Test
        @DisplayName("숫자로 변환할 수 없는 경우 예외를 발생한다.")
        void failNonNumber() {
            // given
            String input = "weekday";

            setSystemInput(input);

            // when
            ThrowingCallable target = RacingGameConsole::readEndLap;

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void setSystemInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
    }
}
