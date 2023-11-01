package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class ResultUtilTest {
    @Test
    void 라운드_결과_출력형식_테스트() {
        String result = ResultUtil.roundFormat(Arrays.asList(new Car("A"), new Car("B")));
        assertThat(result)
                .contains("A : ")
                .contains("B : ");
    }
}
