package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class createCars {

        @Test
    public void testGetCarAtIndex() {
        // 테스트할 Cars 객체 생성
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        // 인덱스 1에 해당하는 Car 객체 가져오기
        Car car = cars.get(1);

        // 예상 결과와 비교
        assertEquals("Car2", car.getName());
    }

    @Test
    public void testToString() {
        // 테스트할 Cars 객체 생성
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        // Cars 객체를 문자열로 변환
        String carsAsString = cars.toString();

        // 예상 결과와 비교
        assertTrue(carsAsString.contains("[Car1, Car2, Car3]"));
    }

    @Test
    public void testSize() {
        // 테스트할 Cars 객체 생성
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        // Cars 객체의 크기 확인
        int size = cars.size();

        // 예상 결과와 비교
        assertEquals(3, size);
    }

}
