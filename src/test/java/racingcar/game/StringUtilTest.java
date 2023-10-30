package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringUtilTest {

    @Test
    void 자동차_이름_쉼표_기준으로_구분() {
        String carNames = "pobi,woni,jun";
        List<String> carNameList = StringUtil.separate(carNames);

        Assertions.assertThat(carNameList).containsExactly("pobi", "woni", "jun");
    }

}