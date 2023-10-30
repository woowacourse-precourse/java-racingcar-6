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
}
