package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingConditionTest {
    private MovingCondition movingCondition;

    @BeforeEach
    void setUp() {
        movingCondition = new MovingCondition();
    }

    @Test
    @DisplayName("조건이 4 이상 경우 true를 반환해야 함")
    void testReturnTrue() {
        int condition = 4;

        assertTrue(movingCondition.isMovingForward(condition));
    }



    @Test
    @DisplayName("조건이 3 이하 경우 false 반환해야 함")
    void testReturnFalse() {
        int condition = 3;

        assertFalse(movingCondition.isMovingForward(condition));
    }
}