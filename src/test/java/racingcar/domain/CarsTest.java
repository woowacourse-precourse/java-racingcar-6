package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
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
    void 랜덤_숫자_받아서_car_클래스_접함(){
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
    @Test
    void 우승자_리스트_얻기(){
        //given
        cars.getCars().get(0).goForward(1);
        cars.getCars().get(1).goForward(7);
        cars.getCars().get(2).goForward(3);

        //when
        List<String> mvp = cars.getMVP();

        //then
        assertThat(mvp).containsExactly("jun");
    }

    @Test
    void 전진_상태_얻기(){

    }

    @Test
    void 리스트_얻기(){

    }

}