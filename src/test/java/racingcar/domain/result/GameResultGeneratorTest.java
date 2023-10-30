package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultGeneratorTest {

    @Test
    public void 최종_우승자_판단하는_기능() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("스폰지밥", 5));
        carList.add(new Car("뚱이", 3));
        carList.add(new Car("징징이", 4));

        Cars cars = Cars.createCars(carList);

        //when
        GameResult gameResult = GameResultGenerator.generateResult(cars);

        //then
        assertThat(gameResult.getResult()).isEqualTo("최종 우승자 : 스폰지밥");
    }

    @Test
    public void 최종_우승자_공동_우승_판단하는_기능() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("스폰지밥", 5));
        carList.add(new Car("뚱이", 5));
        carList.add(new Car("징징이", 5));

        Cars cars = Cars.createCars(carList);

        //when
        GameResult gameResult = GameResultGenerator.generateResult(cars);

        //then
        assertThat(gameResult.getResult()).isEqualTo("최종 우승자 : 스폰지밥, 뚱이, 징징이");
    }
}