package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarStringUtilsTest {


    @Test
    @DisplayName("자동차 이름을 쉼표(,)로 구분하여 파싱한다.")
    void parseCarNamesToList() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        List<String> carNameList = RacingCarStringUtils.parseCarNamesToList(carNames);

        // then
        assertThat(carNameList).hasSize(3)
                .contains("pobi", "woni", "jun");
    }
}