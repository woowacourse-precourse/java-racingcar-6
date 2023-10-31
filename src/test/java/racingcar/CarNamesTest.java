package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;

public class CarNamesTest {

    @Test
    void 자동차_이름_게터_테스트() {
        List<String> testCarNames = List.of("pobi", "jun", "king");
        CarNames carNames = new CarNames(testCarNames);

        assertThat(carNames.getNames()).containsExactly("pobi", "jun", "king");
    }


}
