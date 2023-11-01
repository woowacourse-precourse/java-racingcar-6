package racingcar.repository;

import org.junit.jupiter.api.Test;
import racingcar.entity.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    @Test
    void test() {
        GameRepository gameRepository = new GameRepository();

        Game game = new Game(2);

        Long result = gameRepository.save(game);

        assertEquals(result, 0l);
    }

    @Test
    void test3() {
        GameRepository gameRepository = new GameRepository();

        Game game1 = new Game(1);
        Game game2 = new Game(2);
        gameRepository.save(game1);
        Long result = gameRepository.save(game2);

        assertEquals(result, 1l);
    }


    @Test
    void test2() {
        GameRepository gameRepository = new GameRepository();
        Game game = new Game(2);
        Long id = gameRepository.save(game);

        Game result =gameRepository.findById(id);

        assertEquals(result, game);
    }
}