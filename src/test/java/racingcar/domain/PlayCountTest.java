package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도_횟수가_0이하면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> PlayCount.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임을_진행하면_값이_1만큼_줄어든_객체가_반환된다() {
        PlayCount playCount = PlayCount.from(2);

        assertThat(playCount.play()).isEqualTo(PlayCount.from(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "1:true"}, delimiter = ':')
    void 게임종료_조회시_값이_0일때만_true가_반환된다(int initialValue, boolean expected) {
        PlayCount playCount = PlayCount.from(initialValue);
        playCount = playCount.play();

        assertThat(playCount.finished()).isEqualTo(expected);
    }
}
