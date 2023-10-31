package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarStringUtilsTest {


    @Test
    @DisplayName("자동차 이름을 쉼표(,)로 구분하여 파싱하고 List로 반환한다.")
    void parseCarNamesToList() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        List<String> carNameList = RacingCarStringUtils.parseCarNamesToList(carNames);

        // then
        assertThat(carNameList).hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름을 쉼표(,)로 구분하여 파싱하고 Set으로 반환한다.")
    void parseCarNamesToSet() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        Set<String> carNameSet = RacingCarStringUtils.parseCarNamesToSet(carNames);

        // then
        assertThat(carNameSet).hasSize(3)
                .contains("pobi", "woni", "jun");
    }
}