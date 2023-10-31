package racingcar.controller;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingControllerTest {

    @Test
    @DisplayName("입력된 이름을 바탕으로 차량 등록")
    void 차량_세팅() {
        //given
        String[] names = {"pobi", "woni", "jun"};
        ArrayList<Car> cars = new ArrayList<>();

        //when
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(0); //시작점
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(cars.size()).isEqualTo(3); // 입력한 값 만큼 객체 존재
    }
}