package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setUp() {

        gameService = new GameService();
    }

    @Test
    @DisplayName("우승자가 \"pobi\"인지 테스트")
    void findWinnerTest() {
        // given
        Car pobi = Car.makeCar("pobi");
        Car birdie = Car.makeCar("birdie");
        pobi.move();

        List<Car> cars = List.of(pobi, birdie);

        // when
        List<String> winners = gameService.findWinner(cars);

        // then
        assertAll(
                () -> assertThat(winners).hasSize(1),
                () -> assertThat(winners).containsExactly("pobi")
        );
    }

    @Test
    @DisplayName("우승자가 두명일 경우 두명인지 테스트")
    void findTwoWinnerTest() {
        // given
        Car pobi = Car.makeCar("pobi");
        Car birdie = Car.makeCar("birdie");
        pobi.move();
        birdie.move();

        List<Car> cars = List.of(pobi, birdie);

        // when
        List<String> winners = gameService.findWinner(cars);

        // then
        assertAll(
                () -> assertThat(winners).hasSize(2),
                () -> assertThat(winners).containsExactly("pobi", "birdie")
        );
    }

    @Test
    @DisplayName("숫자가 4 이상일 경우 전진하는지 테스트")
    void moveIfNumberIsBiggerThanFourTest() {
        // given
        int randomNumber = 4;

        // when
        boolean move = gameService.isMove(randomNumber);

        // then
        assertThat(move).isTrue();
    }

    @Test
    @DisplayName("숫자가 3 이하일 경우 전진하지 않는지 테스트")
    void doNotMoveIfNumberIsSmallerThanFour() {
        // given
        int randomNumber = 3;

        // when
        boolean move = gameService.isMove(randomNumber);

        // then
        assertThat(move).isFalse();
    }
}
