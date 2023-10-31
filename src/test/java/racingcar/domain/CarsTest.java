package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.response.ErrorCode.CAR_NAME_DUPLICATION;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 목록 검증")
class CarsTest {

    @Test
    void 자동차_목록_이름_중복_예외() {
        // given
        List<String> input = List.of("car", "car", "name");

        // when
        // then
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATION.getMessage());
    }

    @Test
    void 자동차_목록_생성() {
        // given
        List<String> input = List.of("car", "name", "myCar");

        // when
        Cars result = new Cars(input);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 자동차_경주_우승자() {
        // todo: 메서드를 추가하지 않고, 게임 결과를 예상(조작)할 수 있을지 고민해보기...
    }
}
