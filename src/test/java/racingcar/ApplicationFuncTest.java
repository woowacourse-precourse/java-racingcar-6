package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationFuncTest {

    @DisplayName("차 이름 구하기")
    @Test
    public void getCarNamesTest() {
        String carName = "pobi,woni,jun";
        String[] getCarNames = Application.getCarNames(carName);
        String[] ArrayCarNames = {"pobi", "woni", "jun"};
        assertThat(getCarNames).isEqualTo(ArrayCarNames);
    }
}
