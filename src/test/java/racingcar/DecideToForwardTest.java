package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecideToForwardTest {
    @Test
    public void testDecideToForward() {
        for(int i=0;i<1000;i++){
            boolean result = Application.decideToForward();
            assertTrue(result || !result);
            System.out.println(result);
        }

    }
}
