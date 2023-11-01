package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarListTest {
    @Test
    @DisplayName("자동차 목록 생성 테스트")
    void createCarList() throws NoSuchFieldException, IllegalAccessException {
        CarList carList = new CarList("car1, car2, car3");

        Field carsField = CarList.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        List<Car> cars = (List<Car>) carsField.get(carList);

        assertEquals(3, cars.size());
    }

    @Test
    @DisplayName("자동차 결과 출력 테스트")
    void getRoundResult() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("car");

        Field distanceField = Car.class.getDeclaredField("distance");
        distanceField.setAccessible(true);
        distanceField.set(car, 3);

        String result = car.getRoundResult();
        assertTrue(result.contains("---"));
    }

    @Test
    @DisplayName("우승 자동차 출력 테스트(하나의 우승자)")
    void printSingleWinner() throws NoSuchFieldException, IllegalAccessException {
        CarList carList = new CarList("car1, car2");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        setCarDistance(carList, 0, 3);
        setCarDistance(carList, 1, 2);

        carList.printFinalResult(carList);
        assertTrue(outContent.toString().contains("car1"));
        assertTrue(!outContent.toString().contains("car2"));

        System.setOut(System.out);
    }

    @Test
    @DisplayName("우승 자동차 출력 테스트(2명 이상의 우승자)")
    void printMultipleWinners() throws NoSuchFieldException, IllegalAccessException {
        CarList carList = new CarList("car1, car2");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        setCarDistance(carList, 0, 3);
        setCarDistance(carList, 1, 3);

        carList.printFinalResult(carList);
        assertTrue(outContent.toString().contains("car1"));
        assertTrue(outContent.toString().contains("car2"));

        System.setOut(System.out);
    }

    private void setCarDistance(CarList carList, int carIndex, int distance)
            throws NoSuchFieldException, IllegalAccessException {
        Field carsField = CarList.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        List<Car> cars = (List<Car>) carsField.get(carList);

        Car car = cars.get(carIndex);
        Field distanceField = Car.class.getDeclaredField("distance");
        distanceField.setAccessible(true);
        distanceField.set(car, distance);
    }
}
