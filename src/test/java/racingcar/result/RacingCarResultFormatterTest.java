package racingcar.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarResultFormatterTest {

    private RacingCarResultFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new RacingCarResultFormatter();
    }

    @Test
    @DisplayName("주어진 레이싱 중간 결과에 따라 올바른 형식의 문자열로 포맷한다")
    void formatRoundResult_ShouldFormatCorrectly() {
        // Given
        List<RacingResult> racingRoundResultList = List.of(
                new RacingResult("pobi", 1),
                new RacingResult("woni", 0),
                new RacingResult("jun", 2)
        );

        // When
        String result = formatter.formatRoundResult(racingRoundResultList);

        // Then
        String expected = """
                pobi : -
                woni :\s
                jun : --

                """;
        assertThat(result).isEqualTo(expected);
    }
}
