package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundPlayingTest {
    RoundPlaying master = new RoundPlaying();

    @Test
    void decideToMoveTest() {
        int lowNumber = 2;
        int highNumber = 4;

        assertFalse(master.decideToMove(lowNumber));
        assertTrue(master.decideToMove(highNumber));
    }

    @DisplayName("랜덤 번호 생성 테스트")
    @Test
    void createRandomNumberTest() {
        // 0~9 사이 번호인지 테스트
        int randomNumber = master.createRandomNumber();

        assertTrue(randomNumber <= 9 && randomNumber >= 0);
    }
}