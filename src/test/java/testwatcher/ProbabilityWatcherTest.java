package testwatcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityWatcherTest {
    @DisplayName("최상위 수준에서 getRegisterKey가 올바른 key를 생성한다")
    @Test
    void getRegisterKeyTest() {
        // given
        String className = "testwatcher.ProbabilityWatcherTest";
        String methodName = "getRegisterKeyTest";
        String key = className + "." + methodName;

        // when
        String generatedKey = ProbabilityWatcher.getRegisterKey(1);

        // then
        assertEquals(key, generatedKey);
    }
}
