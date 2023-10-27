package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player = new Player();

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름_입력_테스트() {
        String commaNextCommaInput = "pobi,,jun";
        String commaLastInput = "pobi,jun,,";

        Assertions.assertThatThrownBy(() -> player.checkInputFormat(commaNextCommaInput))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> player.checkInputFormat(commaLastInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}