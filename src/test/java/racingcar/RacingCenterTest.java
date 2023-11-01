package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCenterTest {
    private RacingCenter center;
    private RacingCar car1;
    private RacingCar car2;
    private RacingCar car3;
    @BeforeEach
    void setUp(){
        center = new RacingCenter();
        car1 = new RacingCar("aaa");
        car2 = new RacingCar("bbb");
        car3 = new RacingCar("ccc");
    }
    @Test
    void registCar() {
    }

    @Test
    void all_accel() {
    }

    @Test
    void print_locs() {
    }

    @Test
    void print_bar() {
    }

    @Test
    void compare() {
    }

    @Test
    void find_maxLoc() {
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 2", "4, 5, 5", "7, 8, 8", "0, 8, 8"})
    void new_Vs_Max(int new_num, int max, int ans) {
        int result = center.New_Vs_Max(new_num,  max);
        assertThat(result).isEqualTo(ans);
    }

    @Test
    void find_winners() {
    }

    @Test
    void if_maxLoc_then_add() {

    }
}