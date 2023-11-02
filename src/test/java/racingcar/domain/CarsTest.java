package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    private Car create(String name) {
        return new Car.CarBuilder(name).build();
    }

    private Car createTest(String name, int go) {
        return new Car.CarBuilder(name).setMoveRule(new MoveRule() {
            @Override
            public int tryMove() {
                return go;
            }
        }).build();
    }

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
        List<Car> cars = List.of(create(""), create("가"), create("다"));
        //when,then
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    @Test
    @DisplayName("하나라도 이름의 길이가 5가 넘었으니 IllegalArgumentException 발생시킨다.")
    void 이름_길이_예외_O() {
        //given
        List<Car> cars = List.of(create("가"), create("나나나나나나"), create("다"));
        //when,then
    }

    @Test
    @DisplayName("하나라도 이름의 길이가 5가 넘지 않으면 예외가 발생하지 않는다.")
    void 이름_길이_예외_X() {
        //given
        List<Car> cars = List.of(create("가"), create("나나나나나"), create("다"));
        //when,then
        new Cars(cars);
    }

    @Test
    @DisplayName("이름이 중복이 있으면 예외 발생")
    void 이름_중복_예외_O() {
        //given
        List<Car> cars = List.of(create("가"), create("가"), create("다"));
        //when,then
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    @Test
    @DisplayName("이름이 중복이 없으면 예외 발생안함")
    void 이름_중복_예외_X() {
        //given
        List<Car> cars = List.of(create("가"), create("나"), create("다"));
        //when,then
        new Cars(cars);
    }

    @Test
    @DisplayName("c1이 단독우승이므로 c1만 가져와야 한다.")
    void 단독_우승_테스트_성공() {

        //given
        Car c1 = createTest("가", 3);
        Car c2 = createTest("나", 2);
        Car c3 = createTest("다", 1);

        Cars cars = new Cars(List.of(c1, c2, c3));
        //when
        cars.tryMoveAllCar();
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(1);
        assertThat(cars.getWinningCars().cars().get(0)).isEqualTo(c1);
    }

    @Test
    @DisplayName("c1,c2 동점이므로 c1,c2가 반환되어야 한다.")
    void 공동_우승_테스트_성공() {
        //given
        Car c1 = createTest("가", 2);
        Car c2 = createTest("나", 2);
        Car c3 = createTest("다", 1);
        Cars cars = new Cars(List.of(c1, c2, c3));
        //when
        cars.tryMoveAllCar();
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(2);
        assertThat(cars.getWinningCars().cars()).isEqualTo(List.of(c1, c2));
    }

    @Test
    @DisplayName("c1,c2,c3 동점이므로 c1,c2,c3 가 반환되어야 한다.")
    void 공동_우승_테스트_빵점_성공() {

        //given
        Car c1 = createTest("가", 0);
        Car c2 = createTest("나", 0);
        Car c3 = createTest("다", 0);
        Cars cars = new Cars(List.of(c1, c2, c3));
        //then
        assertThat(cars.getWinningCars().cars()).hasSize(3);
        assertThat(cars.getWinningCars().cars()).isEqualTo(List.of(c1, c2, c3));
    }

    @RepeatedTest(10)
    @DisplayName("1회 테스트 시 모든 점수가 0 ~ 1 사이에서 나와야한다.")
    void 자동차_랜덤_경주_1회() {
        //given
        Cars cars = new Cars(List.of(create("가"), create("나"), create("더")));

        //when
        cars.tryMoveAllCar();
        List<Integer> list = cars.cars().stream().map(e -> (int) e.getDistance()).toList();
        //then
        assertThat(list.stream().allMatch(e -> 0 <= e && e <= 1)).isTrue();
    }

    @RepeatedTest(5)
    @DisplayName("10회 테스트 시 모든 점수가 0 ~ 10 사이에서 나와야한다.")
    void 자동차_랜덤_경주_10회() {
        //given,when
        Cars cars = new Cars(List.of(create("가"), create("나"), create("더")));
        for (int i = 0; i < 10; i++) {
            cars.tryMoveAllCar();
        }
        List<Integer> list = cars.cars().stream().map(e -> (int) e.getDistance()).toList();
        if (list.isEmpty()) {
            Assertions.fail();
        }
        //then
        assertThat(list).allMatch(e -> 0 <= e && e <= 10);
    }
}