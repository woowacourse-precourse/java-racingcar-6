package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class GameTest {

    @Test
    void 시도횟수_대한_예외_처리_입력값이_비어있을때() {
        Game game = new Game();
        assertThatThrownBy(() -> game.setTryNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_대한_예외_처리_입력값이_숫자형태가_아닐때() {
        Game game = new Game();
        assertThatThrownBy(() -> game.setTryNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}