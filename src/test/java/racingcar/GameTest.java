package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 자동차_이름_저장() {
        Game game = new Game();
        String[] carNames = {"이규빈", "삼규빈", "사규빈"};
        game.save(carNames);
        for (int i = 0; i < game.cars.size(); i++) {
            Assertions.assertThat(game.cars.get(i).name).isEqualTo(carNames[i]);
        }
    }

    @Test
    void 이름에_숫자유무_체크() {
        Game game = new Game();
        Assertions.assertThatThrownBy(() -> game.isCharacter("규빈12")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에는 숫자가 들어가면 안됩니다.");

        Assertions.assertThatCode(() -> game.isCharacter("규빈")).doesNotThrowAnyException();
    }

    @Test
    void 이름의_길이_체크() {
        Game game = new Game();
        Assertions.assertThatThrownBy(() -> game.checkNameLength("규빈이랑규빈이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자 이하만 가능합니다.");

        Assertions.assertThatCode(() -> game.checkNameLength("규빈")).doesNotThrowAnyException();
    }
}