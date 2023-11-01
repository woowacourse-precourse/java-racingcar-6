package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NamesTest {

    @Test
    @DisplayName("우승 결과 출력하기 위해 콤마로 구분하여 문자열로 반환한다.")
    void joinNameWithDelimiterTest() {
        // given
        Winners names = new Winners(List.of(
                new Name("pobi"),
                new Name("woni"),
                new Name("jun")));

        // when
        String result = names.joinWinnersNames(", ");

        // then
        assertThat(result).isEqualTo("pobi, woni, jun");
    }
}
