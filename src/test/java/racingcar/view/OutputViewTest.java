package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends IOTest {

    @Test
    void outputGameResultMessage() {
        // given
        OutputView outputView = new OutputView();
        String expected = "실행 결과\n";
        // when
        outputView.outputGameResultMessage();
        // then
        assertThat(getOutput()).isEqualTo(expected);
    }

    @Test
    void outputCarsPosition() {
        // given
        OutputView outputView = new OutputView();
        MovingStrategy moveStrategy = new MovingStrategy((a, b) -> 4);
        Car pobi = new Car(moveStrategy, "pobi", 0);
        Car crong = new Car(moveStrategy, "crong", 0);
        Car nimo = new Car(moveStrategy, "nimo", 0);

        pobi.goForward(); pobi.goForward(); // pobi : --
        crong.goForward(); // crong : -
        // nimo :

        List<Car> cars = List.of(pobi, crong, nimo);
        /** 기대 값
         * pobi : --
         * crong : -
         * nimo :
         *
         */
        String expected = "pobi : --\ncrong : -\nnimo : \n\n";


        // when
        outputView.outputCarsPosition(cars);

        // then
        assertThat(getOutput()).isEqualTo(expected);
    }

    @Test
    void outputWinner() {
        // given
        // when
        // then
    }
}