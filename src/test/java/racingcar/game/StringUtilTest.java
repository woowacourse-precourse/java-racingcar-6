package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @Test
    void 자동차_이름_쉼표_기준으로_구분() {
        String carNames = "pobi,woni,jun";
        List<String> carNameList = StringUtil.separate(carNames);

        assertThat(carNameList).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름_중_중복이_있으면_예외_발생() {
        String carNames = "hwang,jung,seop,jung";
        assertThatThrownBy(() -> StringUtil.separate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 자동차 이름은 서로 달라야 합니다.");
    }

}