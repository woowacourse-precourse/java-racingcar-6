package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {

    @Test
    public void 자동차_생성_테스트() throws Exception {
        //given
        CarService cs = new CarService();

        //when
        List<Car> result = cs.createCar("car1,car2");

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("car1");
        assertThat(result.get(1).getName()).isEqualTo("car2");
    }

    @Test
    public void 다중_자동차_전진_테스트() throws Exception {
        //given
        CarService cs = new CarService();

        List<Car> result = new ArrayList<>();
        result.add(new Car("car1"));
        result.add(new Car("car2"));

        Car car1 = result.get(0);
        Car car2 = result.get(1);

        //when
        cs.moveForwards(result, 4);

        //then
        assertThat(car1.getPosition() == 1);
        assertThat(car2.getPosition() == 1);
    }

    @Test
    public void 다중_자동차_출력_테스트() throws Exception {
        //given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CarService cs = new CarService();
        List<Car> result = new ArrayList<>();
        result.add(new Car("car1"));
        result.add(new Car("car2"));

        cs.moveForwards(result, 4);

        //when
        cs.displayPositions(result);

        //then
        assertThat(outContent.toString().trim().equals("car1 : -\ncar2 : -"));
    }
}