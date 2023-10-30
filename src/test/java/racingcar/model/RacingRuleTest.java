package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingRuleTest {
    
    @Test
    public void 자동차_이름_유효성_테스트() throws Exception {
        // given
        RacingRule racingRule = new RacingRule();

        // when & then
        assertDoesNotThrow(() -> racingRule.isOkToUseCarName("pobi"));
        assertThrows(IllegalArgumentException.class, () -> racingRule.isOkToUseCarName("123456"));
    } 
    
    @Test
    public void 시도_횟수_유효성_테스트() throws Exception {
        // given
        RacingRule racingRule = new RacingRule();

        // when & then
        assertTrue(racingRule.isOkToUseAttemptCount(3));
    } 

}