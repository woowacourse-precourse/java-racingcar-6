package controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarControllerTest {

    private RacingCarController racingCarController = new RacingCarController();

    @Test
    @DisplayName("차량 이름을 쉼표로 구분하는지 확인")
    void extractNameTest() {
        assertThat(racingCarController.extractName("TESLA,BENZ,BMW"))
                .isEqualTo(new HashSet<>(Arrays.asList("TESLA", "BENZ", "BMW")));

        assertThat(racingCarController.extractName("TESLA, BENZ, BMW"))
                .isEqualTo(new HashSet<>(Arrays.asList("TESLA", " BENZ", " BMW")));

        assertThatThrownBy(() -> racingCarController.extractName("TESLA.BENZ.BMW"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이상의 이름은 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName(value = "차량 이름의 길이가 5자를 넘을 경우 IllegalArgumentException 을 발생시키는지 확인")
    @ValueSource(strings = { "VOLKSWAGEN", "CADILLAC", "HYUNDAI", "TESLA", "BENZ", "BMW" })
    void validateLimitNameLengthTest(String carName) {
        if (carName.length() > 5) {
            assertThatThrownBy(() -> racingCarController.extractName(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("5자 이상의 이름은 입력할 수 없습니다.");
        }
    }

    @ParameterizedTest
    @DisplayName(value = "차량 이름이 중복 될 경우 IllegalArgumentException 을 발생시키는지 확인")
    @ValueSource(strings = { "TESLA,TESLA,BENZ", "TESLA,BENZ,BENZ", "BMW,TESLA,BMW" })
    void validateDuplicateNameTest(String carName) {
        assertThatThrownBy(() -> racingCarController.extractName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 사용할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "-", "1a", "-1", "테스트" })
    @DisplayName(value = "사용자가 입력한 반복 횟수가 숫자가 아닐 경우 IllegalArgumentException 을 발생시키는지 확인")
    void validateIsNumericTest(String input) {
        assertThatThrownBy(() -> racingCarController.startRacing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("반복 횟수는 숫자만 입력 가능합니다.");
    }

}