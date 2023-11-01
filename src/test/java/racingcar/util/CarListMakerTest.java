package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class CarListMakerTest {

    @DisplayName("입력된 차량 이름들을, 차량 리스트로 정확하게 변환하는지 확인합니다.")
    @Test
    void makeCarList() {
        String input = "sang,jin,hi,hello,i";

        List<Car> expected = List.of(
                new Car("sang"),
                new Car("jin"),
                new Car("hi"),
                new Car("hello"),
                new Car("i")
        );
        CarListMaker carListMaker = new CarListMaker();
        assertThat(carListMaker.makeCarList(input)).isEqualTo(expected);
    }
}