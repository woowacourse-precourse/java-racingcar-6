package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarResultTest {

    @DisplayName("차 객체를 받으면 해당 차의 이동거리에 대한 문장을 반환")
    @Test
    void createCarMovement() {
        //given
        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        pobiCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);

        //when
        String carMovementResult = RacingCarResult.carMovementResult(pobiCar);

        //then
        assertThat(carMovementResult).isEqualTo("pobi : --");
    }

    @DisplayName("우승자 리스트를 입력받으면 최종 우승자 : 우승자 리스트의 형식으로 반환")
    @Test
    void createWinnerResult() {
        //given
        Car pobiWinner = new Car("pobi");
        Car woniWinner = new Car("woni");
        List<Car> winners = List.of(pobiWinner, woniWinner);

        //when
        String winnersResult = RacingCarResult.winnersResult(winners);

        //then
        assertThat(winnersResult).isEqualTo("최종 우승자 : pobi, woni");
    }
}