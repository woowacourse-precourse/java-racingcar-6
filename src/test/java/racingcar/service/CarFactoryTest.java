package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    public void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    public void 자동차_생성_테스트() {
        String input = "  pobi , woni ,java,se  ,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Car> testCarList = carFactory.generateCars();
        String result = testCarList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        assertThat(result).isEqualTo("pobi, woni, java, se, jun");
    }
}