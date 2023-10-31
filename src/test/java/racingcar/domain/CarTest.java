package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_생성() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        // when, then
        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(woni.getName()).isEqualTo("woni");
    }

    @Test
    void 자동차_전진() {
        // given
        Car car = new Car("car");

        // when
        car.go();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_가능(int number) {
        // given
        Car car = new Car("car");

        // when, then
        assertThat(car.canGo(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_전진_불가능(int number) {
        // given
        Car car = new Car("car");

        // when, then
        assertThat(car.canGo(number)).isFalse();
    }

    @Test
    void 자동차_우승_여부() {
        // given
        Car winnerCar = new Car("fast");
        Car notWinnerCar = new Car("slow");
        int winnerPosition = 1;

        // when
        winnerCar.go();

        // then
        assertThat(winnerCar.isWinner(winnerPosition)).isTrue();
        assertThat(notWinnerCar.isWinner(winnerPosition)).isFalse();
    }
}
