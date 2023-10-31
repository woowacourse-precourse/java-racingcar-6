package racingcar.domain;

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
}
