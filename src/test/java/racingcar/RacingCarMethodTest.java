package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarMethodTest {

    @Test
    void sut는_길이제한을_초과한_입력이_있을_시_true를_반환(){

        List<String> inputList = List.of("pobi", "woni", "javajigi");
        int inputMaxLength = 5;

        var result = Application.isCarnameTooLong(inputList, inputMaxLength);

        assertThat(result).isEqualTo(true);
    }
}
