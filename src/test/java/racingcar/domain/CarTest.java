package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름과 총 전진 횟수를 출력 포멧에 맞춰 출력 문자열을 생성한다.")
    @Test
    void resultMessage() {
        //given
        final String resultMessage = "bonsi : -----";
        Car car = new Car("bonsi", 5);

        //when
        String message = car.resultMessage();

        //then
        assertThat(message).isEqualTo(resultMessage);
    }

    @DisplayName("자동차 간에 총 이동 횟수가 같은지 비교한다.")
    @Test
    void isSameMovementCountBy() {
        //given
        Car car1 = new Car("bonsi", 5);
        Car car2 = new Car("soeun", 5);

        //when
        boolean isSameMovementCount = car1.isSameMovementCountBy(car2);

        //then
        assertThat(isSameMovementCount).isTrue();
    }

    @DisplayName("총 이동 횟수를 기준으로 자동차 간의 대소를 비교한다.")
    @Test
    void compareTo() {
        //given
        Car car1 = new Car("bonsi", 5);
        Car car2 = new Car("soeun", 10);

        //when
        int compareResult = car1.compareTo(car2);

        //then
        assertThat(compareResult).isNegative();
    }

}