package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class WinnersTest {
    @DisplayName("car1, car2가 우승해 우승자 이름이 일치하는지 확인")
    @Test
    void 우승자_이름_테스트() {
        Cars cars1 = Cars.from(Arrays.asList("pobi", "jd"));
        cars1.startRace(() -> true);
        Winners winners1 = Winners.from(cars1);
        String winnerName1 = winners1.getWinnerName();

        assertThat(winnerName1).isEqualTo("pobi, jd");
    }
}