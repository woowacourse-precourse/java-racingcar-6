package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayRoundTest {

    @Test
    void extractPlayRound() {
        PlayRound playRound = new PlayRound("10");
        Assertions.assertThat(playRound.extractPlayRound()).isEqualTo(10);
    }
}