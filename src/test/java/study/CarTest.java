package study;

import org.junit.jupiter.api.Test;
import racingcar.util.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(true);
        assertThat(result4).isEqualTo(false);
        assertThat(result5).isEqualTo(true);
        assertThat(result6).isEqualTo(true);
        assertThat(result7).isEqualTo(false);
        assertThat(result8).isEqualTo(false);
        assertThat(result9).isEqualTo(true);
        assertThat(result10).isEqualTo(false);
        assertThat(result11).isEqualTo(false);
        assertThat(result12).isEqualTo(false);
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
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
        assertThat(result3).isEqualTo(false);
        assertThat(result4).isEqualTo(true);
        assertThat(result5).isEqualTo(false);
        assertThat(result6).isEqualTo(false);
        assertThat(result7).isEqualTo(false);
        assertThat(result8).isEqualTo(false);
        assertThat(result9).isEqualTo(false);
        assertThat(result10).isEqualTo(false);
        assertThat(result11).isEqualTo(false);
        assertThat(result12).isEqualTo(false);
    }

    @Test
    void Get_Name_테스트() {
        Car car = new Car("pobi");
        assertThat(car.Get_Name()).isEqualTo("pobi");
    }

    @Test
    void Get_Position_테스트() {
        Car car = new Car("pobi",5);
        assertThat(car.Get_Position()).isEqualTo(5);
    }
}
