package racingcar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultGeneratorTest {
    private ResultGenerator resultGenerator;

    @BeforeEach
    void setUp() {
        resultGenerator = new ResultGenerator();
    }

    @Test
    void 랜덤_넘버에_따른_전진_정지() throws Exception {
        Method method = ResultGenerator.class.getDeclaredMethod("determineMoveOrStop", int.class);
        method.setAccessible(true);

        assertTrue((Boolean) method.invoke(resultGenerator, 4));  // 4 이상 이면 true
        assertTrue((Boolean) method.invoke(resultGenerator, 5));  // 5 도 true
        assertFalse((Boolean) method.invoke(resultGenerator, 3)); // 3 이하면 false
    }
}