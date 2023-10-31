package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ActionTypeTest {

    @DisplayName("GO는 1, STOP은 0을 리턴한다.")
    @Test
    public void testGetAction() {
        assertEquals(1, ActionType.GO.getAction());
        assertEquals(0, ActionType.STOP.getAction());
    }
}
