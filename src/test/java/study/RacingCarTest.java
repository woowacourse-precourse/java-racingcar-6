package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름 길이가 6 이상일 경우, 예외 발생")
    void 이름길이초과_에러(){
        RacingCar racingCar = new RacingCar();
        Assertions.assertThatThrownBy(() ->
                racingCar.updateCars("부릉부릉카카,부릉카"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("실행 횟수가 정수가 아닐 경우, 예외 발생")
    void 실행횟수_타입_에러(){
        RacingCar racingCar = new RacingCar();
        Assertions.assertThatThrownBy(()->
                racingCar.updateRaceCount("정수"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}