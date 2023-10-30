package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void 예시_입력_테스트() {

        //given
        String uesrInput = "pobi,woni,jun";

        //when
        List<String> carNames = Computer.createCarNames(uesrInput);

        //then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));

    }

}