package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingControllerTest {

    ArrayList<Car> cars;

    @BeforeEach
    void beforeEach() {
        String[] names = {"pobi", "woni", "jun"};
        this.cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    @Test
    @DisplayName("입력된 이름을 바탕으로 차량 등록")
    void 차량_세팅() {
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(0).getPosition()).isEqualTo(0); //시작점
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.size()).isEqualTo(3); // 입력한 값 만큼 객체 존재
    }

    @Test
    @DisplayName("우승자가 맞는지 테스트")
    void 우승자_확인() {
        //given
        int maxPosition = 1;
        String winner = "";

        //when
        cars.get(1).move(); // woni만 이동

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (winner.isEmpty()) {
                    winner = car.getName();
                } else {
                    winner += ", " + car.getName();
                }
            }
        }

        //then
        assertThat(winner).isEqualTo("woni");
    }
}