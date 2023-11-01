package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    Referee referee = new Referee();

    @DisplayName("4이상 입력시 true")
    @Test
    void 전진_조건1() {
        Boolean result = referee.isMovingCondition(4);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @DisplayName("3이하 입력시 false")
    @Test
    void 전진_조건2() {
        Boolean result = referee.isMovingCondition(3);
        Assertions.assertThat(result).isEqualTo(false);
    }

}