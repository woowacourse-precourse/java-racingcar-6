package racingcar.common.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrialCountTest {

    @Test
    public void 시도횟수_생성() {
        String initialCount = "3";
        TrialCount count = TrialCount.of(initialCount);

        Assertions.assertEquals(3, count.getCount());
    }
}
