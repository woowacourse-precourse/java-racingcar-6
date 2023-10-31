package testwatcher;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityWatcherTest {
    @Deprecated
    @Disabled
    @DisplayName("최상위 수준에서 getRegisterKey가 올바른 key를 생성한다")
    @Test
    void getRegisterKeyTestDeprecated() {
        // given
        // <test class이름>.<test method이름>
        String key = "testwatcher.ProbabilityWatcherTest.getRegisterKeyTestDeprecated";

        // when
        String generatedKey = ProbabilityWatcher.getRegisterKey(1);

        // then
        assertEquals(key, generatedKey);
    }

    @DisplayName("최상위 수준에서 getRegisterKey가 올바른 key를 생성한다")
    @Test
    void getRegisterKeyTest(TestInfo testInfo) {
        // given
        // <test class이름>.<test method이름>
        String key = "testwatcher.ProbabilityWatcherTest.getRegisterKeyTest";

        // when
        String generatedKey = ProbabilityWatcher.getRegisterKey(testInfo);

        // then
        assertEquals(key, generatedKey);
    }
}
