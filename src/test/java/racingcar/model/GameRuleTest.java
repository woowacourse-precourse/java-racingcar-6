package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

class GameRuleTest {

    @Test
    public void 전진_가능_테스트() throws Exception {
        // given
        NumberGenerator generator = new StubNumberGenerator(5);
        GameRule gameRule = new GameRule(generator);

        // when
        boolean result = gameRule.isOkToMove();

        // then
        assertTrue(result, "자동차가 전진할 수 없습니다!");
    }

    @Test
    public void 전진_불가능_테스트() throws Exception {
        //given
        NumberGenerator generator = new StubNumberGenerator(3);
        GameRule gameRule = new GameRule(generator);

        // when
        boolean result = gameRule.isOkToMove();

        // then
        assertFalse(result, "자동차가 멈추지 않습니다!");
    }
    
    @Test
    public void 자동차_이름_유효성_테스트() throws Exception {
        // given
        NumberGenerator generator = new StubNumberGenerator(5);
        GameRule gameRule = new GameRule(generator);

        // when & then
        assertDoesNotThrow(() -> gameRule.isOkToUseCarName("pobi"));
        assertThrows(IllegalArgumentException.class, () -> gameRule.isOkToUseCarName("123456"));
    } 
    
    @Test
    public void 시도_횟수_유효성_테스트() throws Exception {
        // given
        NumberGenerator generator = new StubNumberGenerator(5);
        GameRule gameRule = new GameRule(generator);

        // when & then
        assertTrue(gameRule.isOkToUseAttemptCount(3));
    } 

}