package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void getCars() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        List<Car> allCars = List.of(car1, car2, car3);
        Cars cars = new Cars(allCars);
        //when
        List<Car> actual = cars.getCars();
        //then
        assertEquals(allCars, actual);
    }

    @Test
    @DisplayName("getCarsLength() 메서드 테스트")
    void getCarsLength() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        //when
        List<Car> allCars = List.of(car1, car2, car3);
        Cars cars = new Cars(allCars);
        int actual = cars.getCarsLength();

        //then
        assertEquals(3, actual);
    }

    @Test
    @DisplayName("정상적으로 출력이 되는지 테스트")
    void testToString() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        //when
        List<Car> allCars = List.of(car1, car2, car3);
        Cars cars = new Cars(allCars);
        String actual = cars.toString();

        //then
        assertEquals("""
                pobi :\s
                crong :\s
                honux :\s
                """, actual);

    }
}