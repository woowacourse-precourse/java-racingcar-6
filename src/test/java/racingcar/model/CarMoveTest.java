package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.constant.GameMessage;

class CarMoveTest {

    @Test
    void 난수_결과따라_이동여부_결정() {
        // given
        CarMove carMove = new CarMove();

        // when
        int digit = carMove.pickRandNum();

        // then
        if (digit >= GameMessage.GO_MIN_VALUE) {
            assertThat(carMove.decideMove(digit)).isEqualTo(true);
        } else {
            assertThat(carMove.decideMove(digit)).isEqualTo(false);
        }
    }


}