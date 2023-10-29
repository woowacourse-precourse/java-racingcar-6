package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoveStatusTest {
    @Test
    void MoveStatus_인스턴스_생성확인() {
        MoveStatus moveStatus = new MoveStatus();
    }

    @Test
    void canMove_동작확인() {
        MoveStatus moveStatus = new MoveStatus();
        moveStatus.setTestMoveStatus(true);
        int randomNumber = 3;
        boolean moveResult = moveStatus.canMove();
        assertThat(moveResult).isEqualTo(true);
    }

    @Test
    void canMove_동작확인2() {
        MoveStatus moveStatus = new MoveStatus();
        moveStatus.setTestMoveStatus(false);
        int randomNumber = 3;
        boolean moveResult = moveStatus.canMove();
        assertThat(moveResult).isEqualTo(false);
    }
}