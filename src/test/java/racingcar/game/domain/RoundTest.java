package racingcar.game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RoundTest {

    @Test
    void 라운드_객체_생성() {
        Round round = Round.create("5");
        assertThat(round).isNotNull();
    }

}