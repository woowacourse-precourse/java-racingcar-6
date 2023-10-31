package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("자동차들 생성")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test2", "test1,test2,test3"})
    public void create(String carNames) {
        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차들 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test1", "test1,test2,test2", "test1,test2,test1"})
    public void createFail(String carNames) {
        assertThatThrownBy(() -> new Cars(carNames)).isInstanceOf(IllegalArgumentException.class);
    }


}
