package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void set_up() {
        this.user = new User();
    }

    @Test
    void 자동차_객체_생성() {
        // given
        List<String> carNameList = new ArrayList<>();
        carNameList.add("car1");
        carNameList.add("car2");
        carNameList.add("car3");

        List<Car> carList = user.createCarFromCarName(carNameList);

        // when

        // then
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName()).isEqualTo("car1");
        assertThat(carList.get(0).getStatus()).isEqualTo(0);
    }

    @Test
    void 이동을_시도할_횟수_입력() {
        // given
        String roundTime = "5";

        // when

        // then
        assertThat(roundTime).isEqualTo("5");
    }
}
