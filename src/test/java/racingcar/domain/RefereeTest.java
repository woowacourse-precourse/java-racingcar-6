package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("심판은 우승자를 최소 1명 결정해야한다.")
    void determineRefereeMinOneWinner() {
        //given
        Car first = Car.createForStart("테스트1");
        first.moveStraight(5);
        Car second = Car.createForStart("테스트2");
        second.moveStraight(3);
        Car third = Car.createForStart("테스트3");
        third.moveStraight(4);
        List<Car> cars = List.of(first, second, third);

        //when
        List<String> results = Referee.determineWinner(cars);

        //then
        Assertions.assertThat(results.size()).isGreaterThan(1);
    }

}