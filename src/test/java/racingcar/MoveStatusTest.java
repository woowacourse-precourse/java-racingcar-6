package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

class MoveStatusTest {
    @Test
    void MoveStatus_인스턴스_생성확인() {
        MoveStatus moveStatus = new MoveStatus();
    }

    @Test
    void canMove_동작확인() {
        MoveStatus moveStatus = new MoveStatus();
        int randomNumber = 5;
        boolean moveResult = moveStatus.canMove(randomNumber);
        assertThat(moveResult).isEqualTo(true);
    }

    @Test
    void canMove_동작확인2() {
        MoveStatus moveStatus = new MoveStatus();
        int randomNumber = 3;
        boolean moveResult = moveStatus.canMove(randomNumber);
        assertThat(moveResult).isEqualTo(false);
    }
}