package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    @Test
    void 자동차들모델로만들기(){
        GameService gameService = new GameService();
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        List<Car> cars = gameService.makeCars(carNames);

        List<String> names = new ArrayList<>();
        for (Car car:cars){
            names.add(car.getName());
        }
        assertThat(names).contains("car1","car2","car3");
    }
}