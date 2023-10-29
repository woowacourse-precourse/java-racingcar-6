package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("경주 자동차 일급컬렉션의 객체에")
class RacingCarsTest {

    @Nested
    @DisplayName("생성 요청시")
    class CreateValidation {

        @Test
        @DisplayName("요소의 개수가 1개 이하면 예외를 던지는가")
        void oneCar() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new RacingCars(List.of(new RacingCar(new Name("abc")))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 중복되면 예외를 던지는가")
        void duplicateCar() {
            // given
            // when
            // then
            assertThatThrownBy(
                            () ->
                                    new RacingCars(
                                            List.of(
                                                    new RacingCar(new Name("abc")),
                                                    new RacingCar(new Name("abc")))))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("자동차 개수를 요청하면 올바른 개수를 반환하는가")
    void numOfElement() {
        // given
        final List<RacingCar> elements =
                List.of(new RacingCar(new Name("abc")), new RacingCar(new Name("def")));
        final RacingCars racingCars = new RacingCars(elements);

        // when
        final int result = racingCars.numOfElement();

        // then
        assertThat(result).isEqualTo(elements.size());
    }

    @Nested
    @DisplayName("숫자에 따라 이동을 요청할 때")
    class MoveByNumbers {

        @Test
        @DisplayName("4이상의 숫자인 경우 이동하는가")
        void greaterThan4() {
            // given
            final RacingCars racingCars =
                    new RacingCars(
                            List.of(
                                    new RacingCar(new Name("abc")),
                                    new RacingCar(new Name("def"))));

            // when
            racingCars.moveByNumbers(List.of(4, 5));

            // then
            assertThat(racingCars.toResultMessage()).contains("-");
        }

        @Test
        @DisplayName("4이상의 숫자인 경우 이동하는가")
        void lessThan4() {
            // given
            final RacingCars racingCars =
                    new RacingCars(
                            List.of(
                                    new RacingCar(new Name("abc")),
                                    new RacingCar(new Name("def"))));

            // when
            racingCars.moveByNumbers(List.of(1, 2));

            // then
            assertThat(racingCars.toResultMessage()).doesNotContain("-");
        }
    }

    @Test
    @DisplayName("결과 메시지를 요청하면 모든 자동차에 대한 결과 문자열을 반환하는가")
    void toResultMessage() {
        // given
        final String firstCarName = "abc";
        final String secondCarName = "def";
        final RacingCars racingCars =
                new RacingCars(
                        List.of(
                                new RacingCar(new Name(firstCarName)),
                                new RacingCar(new Name(secondCarName))));

        // when
        final String resultMessage = racingCars.toResultMessage();

        // then
        assertThat(resultMessage).contains(firstCarName, secondCarName);
    }

    @Test
    @DisplayName("우승자를 요청하면 가장 많이 이동한 자동차 목록을 반환하는가")
    void findWinners() {
        // given
        final String firstWinner = "abc";
        final String secondWinner = "def";
        final RacingCars racingCars =
                new RacingCars(
                        List.of(
                                new RacingCar(new Name(firstWinner)),
                                new RacingCar(new Name(secondWinner))));
        racingCars.moveByNumbers(List.of(4, 4));

        // when
        final Winners winners = racingCars.findWinners();

        // then
        assertThat(winners.toResultMessage()).contains(firstWinner, secondWinner);
    }
}
