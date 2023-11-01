package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player = new Player();

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름_입력_테스트() {
        String commaNextCommaInput = "pobi,,jun";
        String commaLastInput = "pobi,jun,,";

        assertThatThrownBy(() -> player.checkCarNameFormat(commaNextCommaInput))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> player.checkCarNameFormat(commaLastInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수 숫자 테스트")
    void 이동_횟수_숫자_테스트() {
        String notNumber1 = "13qw3";
        String notNumber2 = "qwe";

        assertThatThrownBy(() -> player.checkMovingCountFormat(notNumber1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> player.checkMovingCountFormat(notNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}