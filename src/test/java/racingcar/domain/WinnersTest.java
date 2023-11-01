package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";

    @Test
    void toString메서드로_최종_우승자_한명_출력하기() {
        //given
        List<String> carNames = Arrays.asList(CAR1_NAME);
        CarNames carNamesObject = new CarNames(carNames);
        Winners winners = new Winners(carNamesObject);
        String expectedWinners = String.format("최종 우승자 : %s", CAR1_NAME);

        //when
        String actualWinners = winners.toString();

        //then
        assertThat(actualWinners)
                .isEqualTo(expectedWinners);
    }
    @Test
    void toString메서드로_최종_우승자_여러명_출력하기() {
        //given
        List<String> carNames = Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME);
        CarNames carNamesObject = new CarNames(carNames);
        Winners winners = new Winners(carNamesObject);
        String expectedWinners = String.format("최종 우승자 : %s, %s, %s", CAR1_NAME, CAR2_NAME, CAR3_NAME);

        //when
        String actualWinners = winners.toString();

        //then
        assertThat(actualWinners)
                .isEqualTo(expectedWinners);
    }
}