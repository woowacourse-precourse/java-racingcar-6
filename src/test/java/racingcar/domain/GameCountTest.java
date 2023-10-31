package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameCountTest {

    @Test
    void 정적_팩토리_객체가_생성되는지_확인() {
        GameCount gameCount = GameCount.from("2");

        assertThat(gameCount.getCount() == 2);
    }
}