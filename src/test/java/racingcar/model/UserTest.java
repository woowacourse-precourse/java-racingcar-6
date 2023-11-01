package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void exceed5DigitsTest() {
        User user = new User();
        List<String> input = new ArrayList<>(){{
           add("123456");
        }};
        Assertions.assertThatThrownBy(() -> user.exceed5Digits(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 5자를 초과하였습니다.");
    }
}
