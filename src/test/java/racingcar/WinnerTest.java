package racingcar;

import racingcar.model.Cars;
import racingcar.model.Winners;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    @Test
    @DisplayName("우승자 생성 테스트")
    void 우승자_리스트_생성() {
        Cars cars = new Cars("pobi,woni,hand");
        Winners winners = new Winners(cars);
        Assertions.assertThat(winners).isNotNull();
    }
}
