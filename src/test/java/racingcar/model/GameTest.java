package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private final List<Car> cars = List.of(
        new Car("poby"),
        new Car("wony"),
        new Car("hyuk"));

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(cars);
    }

    @Test
    public void 무작위_값이_4_이상일_경우만_전진한다() {
        // given
        List<Integer> expected = List.of(0, 1, 1);

        // when & then
        assertRandomNumberInRangeTest(
            () -> {
                game.run();
                assertThat(carsMoveList()).isEqualTo(expected);
            },
            1, 5, 4
        );
    }

    private List<Integer> carsMoveList() {
        return game.getCars().stream()
            .map(Car::getMoveCount)
            .toList();
    }

}