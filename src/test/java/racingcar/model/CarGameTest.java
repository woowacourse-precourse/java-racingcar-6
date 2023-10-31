package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGameTest {

    private CarGame carGame = new CarGame(new ArrayList<>());

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


    @Test
    public void 최종_우승자_1명_테스트() {
        //given
        List<Cars> input = Arrays.asList(new Cars("JiHun", 2), new Cars("Mac", 1));
        carGame = new CarGame(input);

        //when
        List<String> result = carGame.getWinner();
        String winner = String.join(",", result);

        //then
        Assertions.assertThat("JiHun").isEqualTo(winner);
    }

    @Test
    public void 최종_우승자_2명_테스트() {
        //given
        List<Cars> input = Arrays.asList(new Cars("JiHun", 2), new Cars("Mac", 2));
        carGame = new CarGame(input);

        //when
        List<String> result = carGame.getWinner();
        String winner = String.join(",", result);

        //then
        Assertions.assertThat("JiHun,Mac").isEqualTo(winner);
    }
}