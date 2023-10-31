package racingcar.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameTest {
    static List<String> carNames = List.of("pobi", "woni");
    static List<Car> cars = List.of(new Car(carNames.get(0)), new Car(carNames.get(1)));
    static int stage = 1;
    static Game game = new Game(cars, new RandomNumberGenerator(), stage);

    @Order(1)
    @Test
    void 스테이지_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    Map<String, Integer> result = game.runStage();
                    assertThat(result.size() == 2);
                    assertThat(result.get(carNames.get(0)) == 0);
                    assertThat(result.get(carNames.get(1)) == 1);
                },
                3, 4
        );
    }

    @Order(2)
    @Test
    void 게임_종료_여부() {
        assertTrue(game.isGameEnd());
    }

    @Order(3)
    @Test
    void 우승자_찾기() {
        assertThat(game.findWinner().size() == 1);
        assertThat(game.findWinner().get(0).equals(carNames.get(0)));
    }

    @Order(4)
    @Test
    void 게임_생성_유효성() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Game(cars, new RandomNumberGenerator(), -1))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}