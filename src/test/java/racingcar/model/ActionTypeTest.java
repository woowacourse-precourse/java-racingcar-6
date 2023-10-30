package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ActionTypeTest {

    @DisplayName("반드시 정수 1또는 정수 0을 리턴해야 한다.")
    @Test
    void randomAction_test() {
        for (int i = 0; i < 1000; i++) {
            Integer action = ActionType.randomAction();
            assertNotNull(action);
            assertTrue(action == ActionType.GO.getAction()
                    || action == ActionType.STOP.getAction());
        }
    }
}
