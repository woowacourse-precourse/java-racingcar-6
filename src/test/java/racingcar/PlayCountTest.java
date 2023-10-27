package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.PlayCount;

public class PlayCountTest {

    @Test
    void 횟수는_양수일_때_가능하다() {
        // given & when
        PlayCount count = PlayCount.from("5");
    }
}
