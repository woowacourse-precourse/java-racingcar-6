package racingcar.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.playrule.RandomNumberRacingRule;
import racingcar.properties.RacingProperty;
import racingcar.racingcar.RacingParticipants;

class RacingManagerTest {

    RacingManager racingManager;

    @BeforeEach
    void init() {
        racingManager = new RacingManager(
                new RacingProperty(new RacingParticipants(List.of("a","b","c")), "5", new RandomNumberRacingRule()));
    }

    @Test
    @Order(1)
    void isEnd_시도횟수가_0보다_클때() {
        assertFalse(racingManager.isEnd());
    }

    @Test
    @Order(2)
    void processRacing_레이스_1회_진행후_잔여_시도_횟수_1_감소() {
        racingManager.processRacing();

        assertEquals(racingManager.moveChanceCount(), 4);
    }

    @Test
    @Order(3)
    void isEnd_남은_시도횟수가_0일때() {
        RacingManager racingManager = new RacingManager(
                new RacingProperty(new RacingParticipants(List.of("a","b","c")), "1", new RandomNumberRacingRule()));

        racingManager.processRacing();

        assertTrue(racingManager.isEnd());
    }

}