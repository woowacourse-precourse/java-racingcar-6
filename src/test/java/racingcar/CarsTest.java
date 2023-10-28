package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    @DisplayName("자동차이름을_문자열로_입력하면_리스트로_반환한다(콤마기준으로 구분)")
    void 자동자이름을_입력하면_자동차리스트를_반환한다() {
        Cars cars = new Cars("pobi,woni,jun");

        assertThat(cars.getCars())
                .extracting("name")
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("최종우승자를_반환한다_1명")
    void 최종우승자를_반환한다() {
        Cars cars = new Cars();

        List<String> winners = cars.getWinners(Arrays.asList(
                new Car("pobi", 3)
                , new Car("woni", 2)
                , new Car("jun", 1)));

        assertThat(winners)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("최종우승자를_반환한다_2명이상")
    void 최종우승자를_반환한다_2명이상() {
        Cars cars = new Cars();

        List<String> winners = cars.getWinners(Arrays.asList(
                new Car("pobi", 3)
                , new Car("woni", 3)
                , new Car("jun", 1)));

        assertThat(winners)
                .containsExactly("pobi", "woni");
    }
}
