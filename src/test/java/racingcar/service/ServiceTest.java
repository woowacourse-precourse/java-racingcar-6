package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    @Test
    public void 게임플레이테스트(){
        GameService gameService =new GameService();

        Car car =new Car("super");
        Car car2 = new Car("duper");

        List<Car> carList=new ArrayList<Car>();

        carList.add(car);
        carList.add(car2);

        GameSystem gameSystem = new GameSystem(carList, 2);

        gameService.playGame(gameSystem);

        Assertions.assertThat(gameSystem.getAttemptNum()).isEqualTo(1);

    }
}
