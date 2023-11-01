package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarsTest {
    private Cars cars;
    private String input = "pobi,jun,woni";

    @BeforeEach
    void setUp() {
        cars = new Cars(input);
    }

    @Test
    void 생성자_확인_테스트코드(){
        //when
        assertNotNull(cars);
        //then
        assertEquals(3, cars.cars.size());
    }
    @Test
    void 랜덤_숫자_받아서_car_클래스_접근(){
        //given
        Car mockCar1 = mock(Car.class);
        Car mockCar2 = mock(Car.class);

        cars.getCars().add(mockCar1);
        cars.getCars().add(mockCar2);

        //when
        cars.depart();

        //then
        verify(mockCar1, times(1)).goForward(anyInt());
        verify(mockCar2, times(1)).goForward(anyInt());

    }

}