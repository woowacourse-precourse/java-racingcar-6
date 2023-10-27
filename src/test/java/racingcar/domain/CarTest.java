package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car1 = new Car("car1");
    Car car2 = new Car("car2");

    @Test
    @DisplayName("자동차는 한칸씩 전진해야 한다.")
    void 전진_테스트() {
        //given
        Car car1 = new Car("car1");
        String locate = "";

        //when
        for (int i = 0; i < 5; i++) {
            locate = car1.moveForward();
        }

        //then
        Assertions.assertThat(locate).isEqualTo("-----");
    }

    @Test
    @DisplayName("차가 두대 이상일 때, 전진 테스트")
    void 전진_테스트_2() {
        //given

        String locate1 = "";
        String locate2 = "";

        //when
        for (int i = 0; i < 3; i++) {
            locate1 = car1.moveForward();
        }
        for (int j = 0; j < 5; j++) {
            locate2 = car2.moveForward();
        }

        //then
        Assertions.assertThat(locate1.equals("---")).isEqualTo(true);
        Assertions.assertThat(locate2.equals("-----")).isEqualTo(true);

    }


}