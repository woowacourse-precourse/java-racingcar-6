package racingcar.repository;

import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.entity.Game;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    void test() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("car");

        Long result = carRepository.save(car);

        assertEquals(result, 0l);
    }

    @Test
    void test3() {
        CarRepository carRepository = new CarRepository();

        Game game1 = new Game(1);
        Game game2 = new Game(2);
        carRepository.save(game1);
        Long result = carRepository.save(game2);

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