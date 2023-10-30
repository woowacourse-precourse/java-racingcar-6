package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("List<Cars> 생성 잘 되는지 테스트")
    public void Cars_생성자_테스트() {
        //given
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("lisa"),
                new Car("jiny")
        );

        //when, then
        Assertions.assertThatCode(() -> {
            Cars cars = new Cars(carList);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가장 큰 movingCount를 가진 Car객체의 이름 반환 테스트")
    public void 가장_큰_movingCount_Car_객체_테스트() {
        //given
        Car pobiCar = new Car("pobi");
        Car lisaCar = new Car("lisa");
        Car jinyCar = new Car("jiny");
        lisaCar.increaseMovingCountIfGreater(4, 5);
        Cars cars = new Cars(List.of(pobiCar, lisaCar, jinyCar));

        //when
        List<String> maxMovingCountName = cars.findMaxMovingCount();

        //then
        Assertions.assertThat(maxMovingCountName).isEqualTo(List.of("lisa"));
    }
}
