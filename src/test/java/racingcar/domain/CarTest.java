package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.games.racing.domain.Car;

public class CarTest {

    @Test
    @DisplayName("Car 객체에 대한 getMoveResult() 메서드 테스트")
    public void getMoveResultTest() {
        //given
        Car car = new Car("poby");
        for (int i = 0; i < 4; i++) {
            car.move();
        }
        //when
        String moveResult = car.getMoveResult();
        //then
        assertThat(moveResult).isEqualTo("poby : ----");
    }
}
