package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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
        pobi.tryMove(5);

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
        pobi.tryMove(5);
        birdie.tryMove(5);

        List<Car> cars = List.of(pobi, birdie);

        // when
        List<String> winners = gameService.findWinner(cars);

        // then
        assertAll(
                () -> assertThat(winners).hasSize(2),
                () -> assertThat(winners).containsExactly("pobi", "birdie")
        );
    }
}
