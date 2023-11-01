package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤 숫자 생성 클래스의 객체에")
class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Nested
    @DisplayName("사이즈 만큼 랜덤 숫자 생성 요청시")
    class GenerateWithSize {

        @Test
        @DisplayName("반환되는 목록의 요소 개수가 요청한 사이즈와 일치하는가")
        void isSizeEqual() {
            // given
            // when
            final int size = 3;
            final List<Integer> result = randomNumberGenerator.generateWithSize(size);

            // then
            assertThat(result).hasSize(size);
        }

        @Test
        @DisplayName("각 값들이 1 이상 9 이하인가")
        void isOneToNine() {
            // given
            // when
            final List<Integer> result = randomNumberGenerator.generateWithSize(3);

            // then
            assertThat(result.stream().noneMatch(i -> i < 1 || i > 9)).isTrue();
        }
    }
}
