package racingcar.domain.judge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.ForwardCount;

class WinnerCarsTest {

    @DisplayName("우승자가 한 명일 때 단독 우승자인지 확인")
    @Test
    void hasUniqueWinner1() {
        // given
        WinnerCars winnerCars = new WinnerCars(List.of(
                Car.of(new CarName("haero77"), ForwardCount.from(3L))
        ));

        // when
        boolean result = winnerCars.hasUniqueWinner();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("우승자가 여러 명일 때 단독 우승자인지 확인")
    @Test
    void hasUniqueWinner2() {
        // given
        WinnerCars winnerCars = new WinnerCars(List.of(
                Car.of(new CarName("haero77"), ForwardCount.from(3L)),
                Car.of(new CarName("pobi"), ForwardCount.from(3L))
        ));

        // when
        boolean result = winnerCars.hasUniqueWinner();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("단독 우승자의 이름을 조회할 수 있다.")
    @Test
    void getUniqueWinnerName() {
        // given
        String uniqueWinnerName = "haero77";
        WinnerCars winnerCars = new WinnerCars(List.of(
                Car.of(new CarName(uniqueWinnerName), ForwardCount.from(3L))
        ));

        // when
        String result = winnerCars.getUniqueWinnerName();

        // then
        assertThat(result).isEqualTo(uniqueWinnerName);
    }

    @DisplayName("단독 우승자가 아닐 때 단독 우승자 이름을 조회 시 예외를 발생시킨다.")
    @Test
    void getUniqueWinnerNameException() {
        // given
        WinnerCars winnerCars = new WinnerCars(List.of(
                Car.of(new CarName("haero77"), ForwardCount.from(3L)),
                Car.of(new CarName("pobi"), ForwardCount.from(3L))
        ));

        // when & then
        assertThatThrownBy(winnerCars::getUniqueWinnerName)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("There is no unique winner.");
    }

}