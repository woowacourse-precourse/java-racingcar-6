package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.CarTest.*;

class CarsTest {
    private final static String CAR_NAME_DUPLICATE = "차 이름은 중복될 수 없습니다.";

    @DisplayName("Cars 객체를 정상적으로 생성")
    @Test
    void createCarsSuccess() {
        InputView inputView = new InputView();
        List<String> cars = new ArrayList<>(List.of("pobi,woni,jun", "aa, bb, cc", "a,b,c"));

        for (String car : cars) {
            List<String> names = inputView.parseNames(car);
            assertThatCode(() -> new Cars(names))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("중복되는 차 이름이 있는지 검증")
    @Test
    void createCarNameDuplicate_ThrowException() {
        InputView inputView = new InputView();
        List<String> cars = new ArrayList<>(List.of("pobi,woni,jun,pobi", "ab, ab, ab", "aa,bb,bb", "a,a,a,a,a"));

        for (String car : cars) {
            List<String> names = inputView.parseNames(car);
            assertThatThrownBy(() -> new Cars(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_DUPLICATE);
        }
    }

    @DisplayName("여러 자동차 일괄 움직임 테스트")
    @Test
    void moveTest() {

        InputView inputView = new InputView();
        String input = "pobi,woni,jun";
        List<String> names = inputView.parseNames(input);
        Cars cars = new Cars(names);

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(new ArrayList<>(List.of(5, 1, 4, 2, 3, 6, 7, 2, 9)));
        cars.move(testNumberGenerator);
        cars.move(testNumberGenerator);
        cars.move(testNumberGenerator);

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(3);
    }
}