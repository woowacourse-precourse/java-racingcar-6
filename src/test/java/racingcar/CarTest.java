package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarService;

public class CarTest {

    @Test
    public void 자동차_전진_조건_부합() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(4);
        car.moveForward(5);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 자동차_전진_조건_미달() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(2);
        car.moveForward(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 결과_출력() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(4);
        car.moveForward(4);
        car.moveForward(4);

        // then
        assertThat(car.getRoundResult()).isEqualTo("brian : ---");
    }

    @Test
    public void 이름_반환() throws Exception{
        // given
        CarService carService = new CarService();
        carService.setCars("brian");

        // when
        Car car = carService.cars.get(0);

        // then
        assertThat(car.getName()).isEqualTo("brian");
    }
}
