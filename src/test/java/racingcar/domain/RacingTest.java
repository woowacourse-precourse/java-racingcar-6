package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class RacingTest {
    @Test
    void 경주에_사용할_자동차들을_생성한다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"), new CarName("woni"));
        // when
        Racing racing = new Racing(carNameList);
        // then
        assertThat(racing).isNotNull();
    }

    @Test
    void 자동차가_2대_미만일_경우_예외를_발생시킨다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"));
        // when
        // then
        assertThatThrownBy(() -> new Racing(carNameList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

}