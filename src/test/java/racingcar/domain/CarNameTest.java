package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarNameTest {

    @DisplayName("CarName 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"김김김", "최최최", "박박박", "abcde"})
    void createCarNameSuccessTest(String name) {
        CarName carName = new CarName(name);

        assertThat(carName.getName()).isEqualTo(name);
    }

}