package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarNamesTest {
    
    @Test
    void 자동차_개수가_2개_미만일_경우_예외가_발생한다() {
        // given
        String carNames = "자동차1";

        // when, then
        assertThatThrownBy(() -> new CarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_개수가_2개_이상일_경우_예외가_발생하지_않는다() {
        // given
        String carNames = "자동차1,자동차2";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarNames(carNames));
    }

    @Test
    void 중복된_자동차_이름이_존재할_경우_예외를_발생한다() {
        // given
        String carNames = "자동차,자동차";

        // when, then
        assertThatThrownBy(() -> new CarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_자동차_이름이_존재하지_않을_경우_예외를_발생하지_않는다() {
        // given
        String carNames = "자동차1,자동차2";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarNames(carNames));
    }

    @Test
    void 입력받은_이름_문자열로_자동차들을_생성한다() {
        // given
        String carNames = "자동차1,자동차2";
        Car car1 = new Car(new CarName("자동차1"), new Position(0));
        Car car2 = new Car(new CarName("자동차2"), new Position(0));
        Cars expectedCars = new Cars(List.of(car1, car2));

        // when
        Cars cars = new CarNames(carNames).generateCars();

        // then
        assertThat(cars).isEqualTo(expectedCars);
    }

}
