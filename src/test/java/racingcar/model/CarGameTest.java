package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarGameTest {

    private CarGame carGame;

    @BeforeEach
    void setUp() {
        carGame = new CarGame(new ArrayList<>());
    }

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

    @ParameterizedTest
    @CsvSource(value = {"JiHun:Mac:2:1:JiHun", "JiHun:Mac:1:1:JiHun,Mac"}, delimiter = ':')
    public void 최종_우승자_테스트(String car1, String car2, int distance1, int distance2, String expected) {
        //given
        List<Cars> input = Arrays.asList(new Cars(car1, distance1), new Cars(car2, distance2));
        carGame = new CarGame(input);

        //when
        List<String> result = carGame.getWinner();
        String winner = String.join(",", result);

        //then
        Assertions.assertThat(expected).isEqualTo(winner);
    }

}