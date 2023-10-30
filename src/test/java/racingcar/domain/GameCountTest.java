package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameCountTest {

    @ParameterizedTest
    @DisplayName("게임카운트횟수가 남아있으면 true 없으면 false 반환")
    @CsvSource(value = {"1, true", "0, false"})
    void hasRemainCountTest(String num, boolean expect) {
        //given
        GameCount gameCount = new GameCount(num);

        //when
        boolean result = gameCount.hasRemainCount();

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}
