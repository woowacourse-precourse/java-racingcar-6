package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

class MovingStrategyTest {

    @Test
    @DisplayName("4 보다 작은 숫자인 경우 False 반환")
    void isCarMove_멈춤_테스트() {
        // 4 보다 작은 숫자인 경우 멈춤
        MovingStrategy movingStrategy = new MovingStrategy(() -> 3);
        assertEquals(false, movingStrategy.isCarMove());
    }

    @Test
    @DisplayName("4 이상의 숫자인 경우 true 반환")
    void isCarMove_전진_테스트() {
        // 4 이상의 숫자인 경우 전진
        MovingStrategy movingStrategy = new MovingStrategy(() -> 4);
        assertEquals(true, movingStrategy.isCarMove());

    }


}