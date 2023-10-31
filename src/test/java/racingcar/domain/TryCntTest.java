package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCntTest {
    @Test
    @DisplayName("시도 횟수 객체 생성")
    public void createTryCntInstance() {
        // given
        String input = "1";
        // when
        TryCnt tryCnt = TryCnt.createTryCnt(input);
        // then
        assertThat(tryCnt).isNotNull();
        assertThat(tryCnt).isInstanceOf(TryCnt.class);
    }
}