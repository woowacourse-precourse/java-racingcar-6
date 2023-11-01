package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.stub.StubNumberGenerator;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        NumberGenerator numberGenerator = new StubNumberGenerator();
        player = new Player(numberGenerator);
    }

    @Test
    void 이름으로_차량을_생성하면_이름을_가지고_움직임_횟수가_0인_차량이_생성된다() {
        List<String> names = List.of("abc", "def");

        player.addCars(names);

        assertThat(player.getCars()).map(Car::name, Car::moveCount)
            .containsExactly(tuple("abc", 0), tuple("def", 0));
    }

    @Test
    void 차량들을_움직여_조건의_숫자보다_크면_움직임이_증가한_차량이_생성된다() {
        List<String> names = List.of("abc", "def");
        player.addCars(names);

        player.moveCars();

        assertThat(player.getCars()).map(Car::name, Car::moveCount)
            .containsExactly(tuple("abc", 1), tuple("def", 1));
    }
}
