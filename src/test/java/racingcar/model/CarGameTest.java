package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGameTest {

    private final CarGame carGame = new CarGame();

    @Test
    public void trim_메서드_이름_입력시_양쪽_공백은_문자_길이에_미포함() {
        //given
        String input = " JiHun ";

        //when
        carGame.setCars(input);
        int length = carGame.getCars().get(0).getName().length();

        //then
        Assertions.assertThat(5).isEqualTo(length);
    }

}