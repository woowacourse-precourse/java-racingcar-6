package racingcar.domain.power;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("파워 테스트")
class PowerTest {

    @DisplayName("움직일 수 있는 임계값과 비교하여 충분한 파워를 가지고 있는지 알 수 있다")
    @Test
    void testIsSufficientPowerToMove() {
        PowerGenerator powerGenerator = new DefaultPowerGenerator();
        Power power = new Power(4);

        assertTrue(power.isSufficientPowerToMove(new Power(0)));
        assertTrue(power.isSufficientPowerToMove(new Power(4)));
        assertFalse(power.isSufficientPowerToMove(new Power(9)));
    }
}