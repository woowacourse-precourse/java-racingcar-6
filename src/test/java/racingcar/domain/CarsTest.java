package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    @DisplayName("하나라도 이름의 길이가 5가 넘었으니 IllegalArgumentException 발생시킨다.")
    void 이름_길이_예외_O() {
        //given
        List<Car> cars = List.of(new Car("가"), new Car("나나나나나나"), new Car("다"));
        //when,then
    }

    @Test
    @DisplayName("하나라도 이름의 길이가 5가 넘지 않으면 예외가 발생하지 않는다.")
    void 이름_길이_예외_X() {
        //given
        List<Car> cars = List.of(new Car("가"), new Car("나나나나나"), new Car("다"));
        //when,then
        new Cars(cars);
    }

    @Test
    @DisplayName("이름이 중복이 있으면 예외 발생")
    void 이름_중복_예외_O() {
        //given
        List<Car> cars = List.of(new Car("가"), new Car("가"), new Car("다"));
        //when,then
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    @Test
    @DisplayName("이름이 중복이 없으면 예외 발생안함")
    void 이름_중복_예외_X() {
        //given
        List<Car> cars = List.of(new Car("가"), new Car("나"), new Car("다"));
        //when,then
        new Cars(cars);
    }
}