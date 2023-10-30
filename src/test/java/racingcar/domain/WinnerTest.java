package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    @DisplayName("생성자에 이름을 넣고 toString으로 그 이름을 반환")
    void toStringTest() {
        //given
        Winner winner;
        String name = "testCar";

        //when
        winner = new Winner(name);
        String result = winner.toString();

        //then
        assertThat(result).isEqualTo("testCar");
    }
}
