package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.CarNameValidator.*;

public class ValidTest {

    @Test
    void 이름_6자_이상에_대한_예외_처리(){
        List<String> inputList = new ArrayList<>(Arrays.asList("pobi", "woonni", "jun"));

        assertThatThrownBy(() -> checkLength(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복된_경우에_대한_예외_처리(){
        List<String> inputList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun", "pobi"));

        assertThatThrownBy(() -> checkDuplicated(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
