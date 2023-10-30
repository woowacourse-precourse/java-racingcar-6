package model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


public class CarsTest {
    private static MockedStatic<RandomNumber> randoms;

    @BeforeAll
    public static void beforeClass() {
        randoms = mockStatic(RandomNumber.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    public void 전체자동차1칸이동() {

        when(RandomNumber.generateRandomNumber()).thenReturn(4); // 항상 4보다 큰 값을 반환하도록 설정

        List<Car> carsAslist = new ArrayList<>();
        carsAslist.add(new Car("Car1"));
        carsAslist.add(new Car("Car2"));
        carsAslist.add(new Car("Car3"));

        Cars cars = new Cars(carsAslist);

        cars.moveAll();

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 전체자동차이동안함() {
        when(RandomNumber.generateRandomNumber()).thenReturn(3); // 항상 4보다 큰 값을 반환하도록 설정

        List<Car> carsAslist = new ArrayList<>();
        carsAslist.add(new Car("Car1"));
        carsAslist.add(new Car("Car2"));
        carsAslist.add(new Car("Car3"));

        Cars cars = new Cars(carsAslist);

        cars.moveAll();

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

}