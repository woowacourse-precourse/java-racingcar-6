package racingcar;


import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CountInputTest {
    @Test
    void 게임_횟수_입력_테스트() {
        // given
        final int expectedCount = 10;
        final String input = "10";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final int actualCount = UserInput.inputCountOfGames();

        // then
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }
}