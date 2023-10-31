package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class CarNamesTest {

    @Test
    void 자동차_이름_게터_테스트() {
        List<String> testCarNames = List.of("pobi", "jun", "king");
        CarNames carNames = new CarNames(testCarNames);

        assertThat(carNames.getNames()).containsExactly("pobi", "jun", "king");
    }

    @Test
    void 자동차_이름_길이_검증_테스트() {
        List<String> testCarNames = List.of("overlengthname", "jun", "king");
        assertThatThrownBy(() -> new CarNames(testCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 5자리를 초과한 자동차 이름이 입력되었습니다.");
    }

}
