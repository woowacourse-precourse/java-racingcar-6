package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.model.RacingRule.isOkToUseAttemptCount;
import static racingcar.model.RacingRule.isOkToUseCarName;

class RacingRuleTest {
    
    @Test
    public void 자동차_이름_유효성_테스트() throws Exception {
        // given
        // when & then
        assertDoesNotThrow(() -> isOkToUseCarName("pobi"));
        assertThrows(IllegalArgumentException.class, () -> isOkToUseCarName("123456"));
    } 
    
    @Test
    public void 시도_횟수_유효성_테스트() throws Exception {
        // given
        // when & then
        assertTrue(isOkToUseAttemptCount(3));
    } 

}