package study;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.checkCarNameUnderFiveLength;
import static racingcar.utils.convertToInteger;

public class FunctionTest {

    @Test
    void test_for_input_racing_car_name(){
        assertThatThrownBy(() ->{
            checkCarNameUnderFiveLength(Arrays.asList("test_length"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_for_input_stepCount_value(){
        assertThatThrownBy(() -> {
            convertToInteger("haha");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
