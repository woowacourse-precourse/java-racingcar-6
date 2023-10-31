package racingcar.game;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.game.constant.CarExceptionMessage.*;

class StringUtilTest {

    @Test
    void 자동차_이름_쉼표_기준으로_구분() {
        String carNames = "pobi,woni,jun";
        List<String> carNameList = StringUtil.separate(carNames);

        assertThat(carNameList).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름_중_중복이_있으면_예외_발생() {
        assertExceptionCase("hwang,jung,seop,jung", EXIST_SAME_NAMES);
    }

    @Test
    void 자동차_이름_개수가_10이하가_아니면_예외_발생() {
        assertExceptionCase("a,b,c,d,e,f,g,h,i,j,k", OUT_OF_COUNT_RANGE);
    }

    private void assertExceptionCase(String carNames, String errorMessage) {
        assertThatThrownBy(() -> StringUtil.separate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}