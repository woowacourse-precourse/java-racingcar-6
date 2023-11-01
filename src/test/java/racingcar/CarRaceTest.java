package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.CarRaceModel;
import racingcar.view.CarRaceView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {

    @Test
    void splitCarNames_문자열_구분_순서() {
        String input = "car1,car2";
        CarRaceView view = new CarRaceView();
        List<String> carNames = view.splitCarNames(input);
        assertThat(carNames).contains("car2", "car1");
        assertThat(carNames).containsExactly("car1", "car2");
    }

    @Test
    void validateCarNames_문자열_에러() {
        String input = "car12345";
        CarRaceView view = new CarRaceView();
        assertThatThrownBy(() -> view.splitCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void splitCarNames_문자_구분자_반환() {
        String input = "car1";
        CarRaceView view = new CarRaceView();
        List<String> carNames = view.splitCarNames(input);
        assertThat(carNames).contains("car1");
    }

    @Test
    void testCalculateWinners_문자열_길이로_우승자_결정() {
        CarRaceModel model = new CarRaceModel();
        model.initialize(List.of("Car1", "Car2", "Car3"));
        List<String> winners = model.calculateWinners();
        assertThat(winners).containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    void testCalculateMaxDistance_문자열_길이_가장_큰_값_선택() {
        CarRaceModel model = new CarRaceModel();
        model.initialize(List.of("Car1 : --", "Car2 : ---", "Car3 : ----"));
        int maxDistance = model.calculateMaxDistance();
        assertThat(maxDistance).isEqualTo(4);
    }
}
