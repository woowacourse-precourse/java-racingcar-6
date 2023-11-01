package racingcar.vo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundCountTest {
    @Test
    void roundCount_생성_성공() {
        // given
        int roundCount = 5;
        // when
        RoundCount round = new RoundCount(roundCount);
        // then
        Assertions.assertThat(round.getCount()).isEqualTo(5);
    }

    @Test
    void roundCount가_1미만이면_실패() {
        // given
        int roundCount = 0;
        // when
        // then
        Assertions.assertThatThrownBy(() -> new RoundCount(roundCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이동횟수는 1 이상이어야 합니다.");
    }

}