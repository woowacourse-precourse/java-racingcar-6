package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CarNamesValidatorTest {

    @Test
    @DisplayName("쉼표를 구분해서 문자열을 입력하면 정확하게 쉼표로 구분해서 리스트를 반환한다.")
    void getValidatedCarNamesList() {
        // given
        String inputtedCarNames = "pobi,woni,jun";

        // when
        List<String> validatedCarNames = CarNamesValidator.getValidatedCarNamesList(inputtedCarNames);

        // then
        assertThat(validatedCarNames.size()).isEqualTo(3);
        assertThat(validatedCarNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("메서드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환한다.")
    void validateOnlyOneCarName() {
        // given
        String inputtedCarNames = "pobi";

        // when
        List<String> validatedCarNames = CarNamesValidator.getValidatedCarNamesList(inputtedCarNames);

        // then
        assertThat(validatedCarNames.size()).isEqualTo(1);
        assertThat(validatedCarNames).containsExactly("pobi");
    }

    @Test
    @DisplayName("쉼표를 구분해서 공백을 자동으로 제거해서 자동차 이름을 입력받는다.")
    void getTrimCarNamesList() {
        // given
        String inputtedCarNames = "     pobi     ,     woni   ,     jun    ";

        // when
        List<String> validatedCarNames = CarNamesValidator.getValidatedCarNamesList(inputtedCarNames);

        // then
        assertThat(validatedCarNames.size()).isEqualTo(3);
        assertThat(validatedCarNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("쉼표 이전에 공백을 입력한 차 이름이 나오면 IllegalArgumentException 발생. 쉼표 다음에 공백은 예외 없이 넘어감.")
    void handleBlankCarName() {
        // given
        String car1AndBlank = "car1,";
        String blankAndCar1 = ",car1";
        String blankAndBlank = ",,";

        // then
        assertThatNoException().isThrownBy(
                () -> CarNamesValidator.getValidatedCarNamesList(car1AndBlank)
        );
        assertThatThrownBy(() -> CarNamesValidator.getValidatedCarNamesList(blankAndCar1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarNamesValidator.getValidatedCarNamesList(blankAndBlank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("아무것도 입력받지 않으면 IllegalArgumentException 발생시킨다.")
    void handleNullCarNamesList() {
        assertThatThrownBy(() -> CarNamesValidator.getValidatedCarNamesList(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자보다 초과된 길이의 자동차 이름을 입력하면 IllegalArgumentException 발생시킨다.")
    void getLongCarName() {
        // given
        String inputtedCarNames = "kyeoungchan, car1";
        String inputtedCarNames2 = "car1, kyeoungchan";

        // then
        assertThatThrownBy(() -> CarNamesValidator.getValidatedCarNamesList(inputtedCarNames))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarNamesValidator.getValidatedCarNamesList(inputtedCarNames2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}