package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car = new Car();

    @Test
    public void 이름_입력시_양쪽_공백은_문자_길이에_미포함() {
        //given
        String input = " JiHun ";

        //when
        car.setCarName(input);
        int length = car.getCarName().get(0).length();

        //then
        Assertions.assertThat(5).isEqualTo(length);

    }
}