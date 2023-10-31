package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentResultMapTest {
    CurrentResultMap currentResultMap = new CurrentResultMap();

    @DisplayName("한 자동차만 전진했을 때 실행 결과 출력")
    @Test
    void printOneMoveCase(){
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        car1.move();
        List<Car> cars = List.of(car1, car2);
        String result = currentResultMap.getCurrentResultMap(cars);
        assertThat(result).isEqualTo("tomas : -\nemily : \n\n");
    }

    @DisplayName("두 자동차 모두 전진했을 때 실행 결과 출력")
    @Test
    void printTwoMoveCase(){
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        car1.move();
        car2.move();
        List<Car> cars = List.of(car1, car2);
        String result = currentResultMap.getCurrentResultMap(cars);
        assertThat(result).isEqualTo("tomas : -\nemily : -\n\n");
    }

    @DisplayName("두 자동차 모두 전진하지 못 했을 때 실행 결과 출력")
    @Test
    void printNothingMoveCase(){
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        List<Car> cars = List.of(car1, car2);
        String result = currentResultMap.getCurrentResultMap(cars);
        assertThat(result).isEqualTo("tomas : \nemily : \n\n");
    }
}
