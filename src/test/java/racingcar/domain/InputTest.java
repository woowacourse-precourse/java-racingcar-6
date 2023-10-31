package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @DisplayName("자동차 입력 정상동작")
    @Test
    void inputCorrect() {
        String cars = "pobi,woni,jun";
        List<String> carList = Input.getSplitList(cars);

        assertThat(carList.get(0)).isEqualTo("pobi");
        assertThat(carList.get(1)).isEqualTo("woni");
        assertThat(carList.get(2)).isEqualTo("jun");
    }
}