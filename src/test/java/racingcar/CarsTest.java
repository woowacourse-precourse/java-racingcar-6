package racingcar;

import racingcar.model.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void 자동차_리스트_생성() {
        Cars cars = new Cars("pobi,woni,hand");
        Assertions.assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 리스트 이름 출력 테스트")
    void 자동차_리스트_이름_출력_테스트() {
        Cars cars = new Cars("pobi,woni,hand");
        Assertions.assertThat(cars.toString()).isEqualTo("pobi,woni,hand");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi,hand"})
    @DisplayName("자동차 리스트 이름 중복 테스트")
    void 자동차_리스트_이름_중복_테스트(String string) {
        Assertions.assertThatThrownBy(() -> new Cars(string))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
