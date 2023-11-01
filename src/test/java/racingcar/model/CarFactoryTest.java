package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void 자동차_생성_테스트(){
        List<String> carNames = Arrays.asList("jk", "yk", "ms");
        CarFactory carFactory = new CarFactory(carNames);

        List<Car> carList = carFactory.getCarList();

        assertThat(carList.get(0).getName().equals("jk"));
        assertThat(carList.get(1).getName().equals("yk"));
        assertThat(carList.get(2).getName().equals("ms"));
    }



}
