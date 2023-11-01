package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountTest {

    @Nested
    @DisplayName("횟수 검증 테스트")
    class ValidationTest {

        @ParameterizedTest(name = "총 횟수 : {0}")
        @CsvSource({"0", "-1"})
        @DisplayName("총 횟수는 1 이상의 양수이어야 한다")
        void validationTest_whenTotalCountIsOutOfRange_throwException(int totalCount) {

            assertThatThrownBy(() -> Count.from(totalCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상 이어야 합니다");
        }
    }

    @Nested
    @DisplayName("반복 실행 테스트")
    class RepeatTest {

        @ParameterizedTest(name = "반복 횟수 : {0}")
        @CsvSource({"1", "10"})
        @DisplayName("초기에 설정한 횟수만큼 반복하여 실행할 수 있다")
        void repeatTest(int totalCount) {
            Count count = Count.from(totalCount);
            Counter counter = new Counter();

            count.repeat(counter::count);

            assertThat(counter.getCount()).isEqualTo(totalCount);
        }

        private static class Counter {

            private int count = 0;

            public void count() {
                count++;
            }

            public int getCount() {
                return count;
            }
        }
    }
}
