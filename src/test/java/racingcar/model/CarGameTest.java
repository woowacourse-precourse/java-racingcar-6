package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGameTest {

    private final CarGame car = new CarGame();

    @Test
    public void 이름_입력시_양쪽_공백은_문자_길이에_미포함() {
        //given
        String input = " JiHun ";

        //when
        car.setCarsName(input);
        int length = car.getCarsName().get(0).getName().length();

        //then
        Assertions.assertThat(5).isEqualTo(length);

    }
}