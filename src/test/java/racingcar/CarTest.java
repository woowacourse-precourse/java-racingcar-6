package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름과 이동 횟수로 출력 형식에 맞게 변환")
    @Test
    void getResult() {
        //given
        Car car = new Car("test", 3);

        //when
        String result = car.getResult();

        //then
        Assertions.assertThat(result).
                contains("test : ---");
    }

}