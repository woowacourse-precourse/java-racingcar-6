package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNamesTest {

    @Test
    public void 이름_길이_검증_테스트() {
        //given
        String input;

        //when
        input = "pobi,woning,jun";

        //then
        Assertions.assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
