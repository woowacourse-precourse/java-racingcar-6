package racingcar.view;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("'실행 결과' 문구 출력 테스트")
    void outputGameResultMessage() {
        // given
        OutputView outputView = new OutputView();
        String expected = "\n실행 결과\n";
        // when
        outputView.outputGameResultMessage();
        // then
        assertThat(getOutput()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 위치 정보 그래프로 출력하는 기능 테스트")
    void outputCarsPosition() {
        // given
        OutputView outputView = new OutputView();
        MovingStrategy moveStrategy = new MovingStrategy((a, b) -> 4);
        Car pobi = new Car(moveStrategy, "pobi");
        Car crong = new Car(moveStrategy, "crong");
        Car nimo = new Car(moveStrategy, "nimo");

        pobi.goForward(); pobi.goForward(); // pobi : --
        crong.goForward(); // crong : -
        // nimo :

        List<Car> carsList = List.of(pobi, crong, nimo);
        String expected = "pobi : --\ncrong : -\nnimo : \n\n";


        // when
        outputView.outputCarsPosition(carsList);

        // then
        assertThat(getOutput()).isEqualTo(expected);
    }

    @Test
    @DisplayName("최종 우승자 문구 출력 기능 테스트")
    void outputWinner() {
        // given
        OutputView outputView = new OutputView();
        MovingStrategy moveStrategy = new MovingStrategy((a, b) -> 4);

        Car pobi = new Car(moveStrategy, "pobi");
        Car crong = new Car(moveStrategy, "crong");

        List<Car> winners = List.of(pobi, crong);
        String expected = "최종 우승자 : pobi, crong\n";

        // when
        outputView.outputWinner(winners);

        // then
        assertThat(getOutput()).isEqualTo(expected.toString());

    }
}