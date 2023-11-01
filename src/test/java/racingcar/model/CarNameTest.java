package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "pob", "pobii"})
    public void 유효한_차_이름(String validCarName) {
        //when
        CarName carName = CarName.create(validCarName);

        //then
        assertThat(carName.getCarName()).isEqualTo(validCarName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobbii"})
    public void 유효하지_않은_차_이름(String invalidCarName) {
        //then
        assertThatThrownBy(() -> CarName.create(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
