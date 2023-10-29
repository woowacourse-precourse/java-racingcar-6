package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameRepositoryTest extends NsTest {

    GameRepository gameRepository = new GameRepository();

    private List<Car> createListOfCars() {
        return List.of(
                new Car("a"),
                new Car("b"),
                new Car("c")
        );
    }

    private Game createGame() {
        return new Game(3, createListOfCars());
    }

    @Test
    void 레포지토리에_게임_저장_후_id로_확인() {
        gameRepository.save(createGame());
        gameRepository.save(createGame());
        assertThat(gameRepository.findById(0L).getCars().get(0).getName()).isEqualTo("a");
        assertThat(gameRepository.findById(0L).getCars().get(1).getName()).isEqualTo("b");
        assertThat(gameRepository.findById(0L).getCars().get(2).getName()).isEqualTo("c");
        assertThat(gameRepository.findById(1L).getCars().get(0).getName()).isEqualTo("a");
        assertThat(gameRepository.findById(1L).getCars().get(1).getName()).isEqualTo("b");
        assertThat(gameRepository.findById(1L).getCars().get(2).getName()).isEqualTo("c");
    }

    @Test
    void 레포지토리에_자동차_저장_후_전체_확인() {
        int n = 4;
        for (int i = 0; i < n; i++) {
            gameRepository.save(createGame());
        }
        assertThat(gameRepository.findAll()).hasSize(n);
    }

    @Override
    protected void runMain() {
    }
}
