package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ActionTypeTest {

    @Test
    void randomAction_test() {
        for (int i = 0; i < 1000; i++) {
            Integer action = ActionType.randomAction();
            assertNotNull(action);
            assertTrue(action == ActionType.GO);
        }
    }

}
