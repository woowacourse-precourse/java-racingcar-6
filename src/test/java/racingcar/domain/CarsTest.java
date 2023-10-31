package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    @DisplayName("List에 Car 객체가 하나도 없다면 예외 발생")
    void 빈_Car_객체_예외_O() {
        //given
        List<Car> cars = List.of();
        //when,then
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    @Test
    @DisplayName("Car 이름이 없는게 있다면 예외 발생")
    void 빈_Car_이름_예외_O() {
        //given
        List<Car> cars = List.of(new Car(""), new Car("가"), new Car("다"));
        //when,then
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

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

    @Test
    @DisplayName("c1이 단독우승이므로 c1만 가져와야 한다.")
    void 단독_우승_테스트_성공() {

        //given
        Car c1 = new Car("가");
        Car c2 = new Car("나");
        Car c3 = new Car("다");
        Cars cars = new Cars(List.of(c1, c2, c3));
        //when
        moveCar(c1, 3);
        moveCar(c2, 2);
        moveCar(c3, 1);
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(1);
        assertThat(cars.getWinningCars().cars().get(0)).isEqualTo(c1);
    }

    @Test
    @DisplayName("c1,c2 동점이므로 c1,c2가 반환되어야 한다.")
    void 공동_우승_테스트_성공() {

        //given
        Car c1 = new Car("가");
        Car c2 = new Car("나");
        Car c3 = new Car("다");
        Cars cars = new Cars(List.of(c1, c2, c3));
        //when
        moveCar(c1, 3);
        moveCar(c2, 3);
        moveCar(c3, 2);
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(2);
        assertThat(cars.getWinningCars().cars()).isEqualTo(List.of(c1, c2));
    }

    @Test
    @DisplayName("c1,c2,c3 동점이므로 c1,c2,c3 가 반환되어야 한다.")
    void 공동_우승_테스트_빵점_성공() {

        //given
        Car c1 = new Car("가");
        Car c2 = new Car("나");
        Car c3 = new Car("다");
        Cars cars = new Cars(List.of(c1, c2, c3));
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(3);
        assertThat(cars.getWinningCars().cars()).isEqualTo(List.of(c1, c2, c3));
    }

    private void moveCar(Car c1, int distance) {
        while (distance-- > 0) {
            c1.move(new TestMoveRule());
        }
    }

    class TestMoveRule implements MoveRule {

        @Override
        public int tryMove() {
            return 1;
        }
    }
}