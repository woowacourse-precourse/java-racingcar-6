package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.Application;
import racingcar.domain.Car;

public class CarServiceTest extends NsTest {

    AppConfig appConfig;
    CarService carService;
    RacingGameService gameService;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        carService = appConfig.carService();
        gameService = appConfig.racingGameService();
    }

    @Test
    void car_저장_성공() {
        //given
        Car car = new Car("paek", 1L);

        //when
        carService.join(car);
        Car savedCar = carService.findCarById(1L);

        //then
        assertThat(car).isEqualTo(savedCar);
    }

    @Test
    void car_여러개_저장_성공() {
        List<Car> list = new ArrayList<>();
        //given
        Car car1 = new Car("paek1", 1L);
        Car car2 = new Car("paek2", 2L);
        //when
        carService.join(car1);
        list.add(car1);
        carService.join(car2);
        list.add(car2);
        List<Car> savedlist = carService.findAllCars();

        //then
        assertThat(list.get(0)).isEqualTo(savedlist.get(0));
        assertThat(list.get(1)).isEqualTo(savedlist.get(1));
    }

    @Test
    public void car_전진_성공() throws Exception {
        //given
        Car car = new Car("paek", 1L);

        //when
        carService.join(car);
        int beforeMovePosition = carService.findCarById(car.getId()).getPosition();
        carService.moveCarToForward(car.getId());
        Car savedCar = carService.findCarById(1L);

        //then
        assertThat(savedCar.getPosition()).isEqualTo(beforeMovePosition + 1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
