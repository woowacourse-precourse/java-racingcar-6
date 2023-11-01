package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차 이름 길이 테스트")
    void validateNameTest() {
        String name = "carNameIsTooLong";
        assertThatThrownBy(() -> new Car(name).validateName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진조건 테스트")
    void isRunConditionTest() {
        final int RUN_STANDARD = 5;
        int pickedNumberOne = 3;
        int pickedNumberTwo = 8;

        boolean runConditionOne = pickedNumberOne >= RUN_STANDARD;
        boolean runConditionTwo = pickedNumberTwo >= RUN_STANDARD;
        assertThat(runConditionOne).isEqualTo(false);
        assertThat(runConditionTwo).isEqualTo(true);
    }

}