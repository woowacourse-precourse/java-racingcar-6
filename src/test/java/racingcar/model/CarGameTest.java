package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGameTest {

    private final CarGame carGame = new CarGame();

    @Test
    public void 이름_입력시_양쪽_공백은_문자_길이에_미포함() {
        //given
        String input = " JiHun ";

        //when
        carGame.setCarsName(input);
        int length = carGame.getCarsName().get(0).getName().length();

        //then
        Assertions.assertThat(5).isEqualTo(length);
    }

    @Test
    public void 자동차_이름_한개_이상_참여_공백만_입력은_금지() {
        String input = " ";

        assertThatThrownBy(() -> carGame.setCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 대 이상의 자동차가 있어야 합니다.");
    }
}