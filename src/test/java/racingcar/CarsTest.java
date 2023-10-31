package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {

    @DisplayName("자동차 이름 길이가 5를 넘어가는 경우 예외 처리 되는지 테스트")
    @Test
    void validateCarsNameLengthTest() {
        String carNames = "abced,a,abcdes";

        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여하는 자동차가 없는 경우 예외 처리가 되는지 테스트")
    @Test
    void validateNotExistCarsTest() {
        String carNames = ",,";

        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름이 존재할 경우 예외 처리가 되는지 테스트")
    @Test
    void validateDuplicateCarsNameTest() {
        assertThatThrownBy(() -> {
            new Cars("aaa,aaa");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
