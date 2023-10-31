package racingcar;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class test {
    @Test
    void test_input_car_name() {
        String input = "kiki, min, hone";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] car_name_list = Application.input_car_name();
        System.setIn(System.in);
        String[] result = {"kiki", "min", "hone"};

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
    void test_check_count(){
        int input = 0;

        assertThatThrownBy(() -> Application.check_count(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_racing_winner() {
        String[] car_name_list = {"kiki", "min", "hone"};

        String[] result1 = {"--", "----", "---"};
        assertThat(Application.racing_winner(car_name_list, result1)).contains("min");

        String[] result2 = {"----", "--", "---"};
        assertThat(Application.racing_winner(car_name_list, result2)).contains("kiki");

        String[] result3 = {"--", "---", "---"};
        assertThat(Application.racing_winner(car_name_list, result3)).contains("min", "hone");
    }

}
