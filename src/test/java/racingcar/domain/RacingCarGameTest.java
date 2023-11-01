package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    RacingCarGame rg = new RacingCarGame();

    @Test
    @DisplayName("자동차_이름_쪼개기_공백삭제")
    void test_splitNamesOfCars() {
        String namesOfCars = "1, 2, 3 ,  4, 창과 방패";
        String[] result = rg.splitNamesOfCars(namesOfCars);
        assertThat(result).containsExactly("1", "2", "3", "4", "창과 방패");
    }

    @Test
    void readNumberOfRace() {

    }

}