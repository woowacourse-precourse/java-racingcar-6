package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void getWinnersNamesTest() {
        String carNames = "isaac,han";
        Winners winners = new Winners(new Cars(carNames));
        assertThat(winners.getWinnersNames()).contains("isaac", "han");
    }
}