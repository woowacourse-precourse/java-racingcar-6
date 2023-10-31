package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class BingBongTest {

    private Racing rc;
    private Car c;

    @BeforeEach
    void class_init() {
        rc = new Racing(0);
        c = new Car("bori", "");
    }

    @Test
    void car_regist() {
        rc.registCars("bing,bong,min,woo");
        ArrayList<Car> cars = rc.cars;
        assertThat(cars).extracting("name").contains("bing","bong","min","woo");
    }

    @Test
    void count_regist() {
        rc.registCount("5");
        assertThat(rc.count).isEqualTo(5);
    }

    @Test
    void car_move() {
        if ( c.move() >= 4 ) {
            assertThat(c.distance).isEqualTo("-");
        } else {
            assertThat(c.distance).isEqualTo("");
        }
    }

    @Test
    void car_name_repeat_exe() {
        String input = "bing,bing";

        assertThatThrownBy(() -> rc.registCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_name_length_exe() {
        String input = "bingbong,promi";

        assertThatThrownBy(() -> rc.registCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_count_0_exe() {
        assertThatThrownBy(() -> rc.registCars(""))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void car_count_0_2_exe() {
        assertThatThrownBy(() -> rc.registCars(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_count_1_exe() {
        assertThatThrownBy(() -> rc.registCars("bing"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_count_1_2_exe() {
        assertThatThrownBy(() -> rc.registCars("bing,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_count_1_3_exe() {
        assertThatThrownBy(() -> rc.registCars("bing, "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void racing_count_not_digit_exe() {
        String input = "a11";

        assertThatThrownBy(() -> rc.registCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void racing_count_empty_exe() {
        assertThatThrownBy(() -> rc.registCount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void racing_count_blank_exe() {
        assertThatThrownBy(() -> rc.registCount(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}