package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarTest {

    Car car;
    Game game;

    LinkedHashMap<String,Integer> cars;

    @BeforeEach
    void setUp(){
        game = new Game(cars);
        car = new Car();

    }

    @Test
    void 자동차_전진_테스트(){
        int carNumber = game.createCarNumber();
        int location = car.moveForward(carNumber);

        Assertions.assertTrue(location>=1);

    }


}
