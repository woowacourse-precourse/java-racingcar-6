package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputMessageTest {
    private OutputMessage outputMessage = new OutputMessage();

    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.")
    @Test
    public void 전진하는_자동차를_출력() {
        //given
        List<Car> cars = Arrays.asList(new Car("pobi", 1), new Car("woni", 3));

        //when
        outputMessage.printMovingCarNames(cars);
        //then - console 확인

    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.")
    @Test
    public void 자동차_경주_우승자_출력() {
        //given
        List<Car> cars = Arrays.asList(new Car("pobi", 3), new Car("woni", 1), new Car("jun", 3));

        //when
        List<Car> carsWinner = outputMessage.printWinnerAfterRaceCompletion(cars);

        //then
        carsWinner.forEach(item -> {
            assertThat(item.getMoveNumber()).isEqualTo(3);
        });

    }

}