package racingcar.developtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.firstClassCollection.CarName;
import racingcar.firstClassCollection.RoundTryCount;

public class ValidationTest {


    @ParameterizedTest
    @ValueSource(strings = {"pobicrong", "", "po ", "po!!"})
    void CarName_자동차_이름_유효한_이름인지_확인(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void RoundTryCount_라운드_카운트_유효한지_확인(int count) {
        assertThatThrownBy(() -> new RoundTryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
