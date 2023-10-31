package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void Position_Comparator_테스트() {
        Car car1 = new Car("pobi",5);
        Car car2 = new Car("min",5);
        Car car3 = new Car("woni",4);
        Car car4 = new Car("jin",3);
        boolean result1 = car1.Position_Comparator(car2);
        boolean result2 = car1.Position_Comparator(car3);
        boolean result3 = car1.Position_Comparator(car4);
        boolean result4 = car2.Position_Comparator(car1);
        boolean result5 = car2.Position_Comparator(car3);
        boolean result6 = car2.Position_Comparator(car4);
        boolean result7 = car3.Position_Comparator(car1);
        boolean result8 = car3.Position_Comparator(car2);
        boolean result9 = car3.Position_Comparator(car4);
        boolean result10 = car4.Position_Comparator(car1);
        boolean result11 = car4.Position_Comparator(car2);
        boolean result12 = car4.Position_Comparator(car3);
        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertTrue(result6);
        assertFalse(result7);
        assertFalse(result8);
        assertTrue(result9);
        assertFalse(result10);
        assertFalse(result11);
        assertFalse(result12);
    }

    //위치가 다른 위치와 같은지 비교
    @Test
    void Same_Position_Check_테스트() {
        Car car1 = new Car("pobi",5);
        Car car2 = new Car("min",5);
        Car car3 = new Car("woni",4);
        Car car4 = new Car("jin",3);
        boolean result1 = car1.Same_Position_Check(car2);
        boolean result2 = car1.Same_Position_Check(car3);
        boolean result3 = car1.Same_Position_Check(car4);
        boolean result4 = car2.Same_Position_Check(car1);
        boolean result5 = car2.Same_Position_Check(car3);
        boolean result6 = car2.Same_Position_Check(car4);
        boolean result7 = car3.Same_Position_Check(car1);
        boolean result8 = car3.Same_Position_Check(car2);
        boolean result9 = car3.Same_Position_Check(car4);
        boolean result10 = car4.Same_Position_Check(car1);
        boolean result11 = car4.Same_Position_Check(car2);
        boolean result12 = car4.Same_Position_Check(car3);
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertFalse(result5);
        assertFalse(result6);
        assertFalse(result7);
        assertFalse(result8);
        assertFalse(result9);
        assertFalse(result10);
        assertFalse(result11);
        assertFalse(result12);
    }

    @Test
    void Get_Name_테스트() {
        Car car = new Car("pobi");
        assertEquals(car.Get_Name(),"pobi");
    }

    @Test
    void Get_Position_테스트() {
        Car car = new Car("pobi",5);
        assertEquals(car.Get_Position(),5);
    }

    @Test
    void Position_Move_테스트(){
        Car car = new Car("pobi",0);
        car.Position_Move(()->true);
        assertEquals(car.Get_Position(),1);
        car.Position_Move(()->false);
        assertEquals(car.Get_Position(),1);
    }
}
