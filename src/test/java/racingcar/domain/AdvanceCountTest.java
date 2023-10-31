package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdvanceCountTest {

    @Test
    @DisplayName("현재 최대 전진 횟수 초기화 테스트")
    void test() {
        //given
        AdvanceCount advanceCount1 = new AdvanceCount();
        AdvanceCount advanceCount2 = new AdvanceCount();

        //when
        advanceCount1.accumulate();
        advanceCount2.accumulate();
        advanceCount2.accumulate();
        int secondInstanceCount = advanceCount2.getCount();

        //then
        assertThat(secondInstanceCount).isEqualTo(AdvanceCount.maxCount);
    }
}
