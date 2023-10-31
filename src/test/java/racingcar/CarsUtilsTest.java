package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CarsUtils;

public class CarsUtilsTest {

    @Test
    void 구분자_콤마로_구분하는_기능_테스트() {
        //given
        String carNames = "jung,yoon,su";

        //when
        String[] splitCarNames = CarsUtils.splitByCommasDelimiter(carNames);

        //then
        Assertions.assertThat(splitCarNames.length).isEqualTo(3);
    }
}
