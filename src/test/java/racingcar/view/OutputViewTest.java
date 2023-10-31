package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void buildResultString_자동차별_문자열을_합쳐_결과_문자열로_만들어_반환한다() {
        //given
        java.util.List<String> carNames = List.of("dawin", "woowa", "han", "tech", "cours");
        List<Integer> roundResult = List.of(1, 2, 3, 4, 5);

        //when
        String result = OutputView.buildResultString(carNames, roundResult);

        //then
        assertThat(result).contains("dawin : -\n",
                "woowa : --\n",
                "han : ---\n",
                "tech : ----\n",
                "cours : -----\n");
    }

    @Test
    void makeResultString_자동차의_이름과_이동_거리를_문자열로_만들어_반환한다() {
        //given
        String carName = "dawin";
        int distance = 7;

        //when
        String result = OutputView.makeResultString(carName, distance);

        //then
        assertThat(result).isEqualTo("dawin : -------\n");
    }
}