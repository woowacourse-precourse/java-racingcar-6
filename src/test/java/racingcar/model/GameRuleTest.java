package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRuleTest {
    
    @Test
    public void 자동차_이름_유효성_테스트() throws Exception {
        // given
        GameRule gameRule = new GameRule();

        // when & then
        assertDoesNotThrow(() -> gameRule.isOkToUseCarName("pobi"));
        assertThrows(IllegalArgumentException.class, () -> gameRule.isOkToUseCarName("123456"));
    } 
    
    @Test
    public void 시도_횟수_유효성_테스트() throws Exception {
        // given
        GameRule gameRule = new GameRule();

        // when & then
        assertTrue(gameRule.isOkToUseAttemptCount(3));
    } 

}