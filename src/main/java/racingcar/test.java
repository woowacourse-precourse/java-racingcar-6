package racingcar;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class test {
    @Test
    void test_input_car_name() {
        String input = "kiki, min, honey";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] car_name_list = Application.input_car_name();
        System.setIn(System.in);
        String[] result = {"kiki", "min", "honey"};

        assertThat(result).isEqualTo(car_name_list);
    }

    @Test
    void test_check_name_validation_empty() {
        String input = "";
        assertThatThrownBy(() -> Application.check_name_validation(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_check_name_validation_longname() {
        String input = "kihyun";
        assertThatThrownBy(() -> Application.check_name_validation(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_input_repeat_count() {
        String input = "count";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setIn(System.in);
        assertThatThrownBy(() -> Application.input_repeat_count()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_check_count(){
        int input = 0;
        assertThatThrownBy(() -> Application.check_count(input)).isInstanceOf(IllegalArgumentException.class);
    }


}
