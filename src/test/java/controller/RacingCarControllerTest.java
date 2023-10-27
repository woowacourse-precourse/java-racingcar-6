package controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarControllerTest {

    @ParameterizedTest
    @DisplayName(value = "차량 이름의 길이가 5자를 넘을 경우 IllegalArgumentException 을 발생시키는지 확인")
    @ValueSource(strings = { "VOLKSWAGEN", "CADILLAC", "HYUNDAI", "TESLA", "BENZ", "BMW" })
    void validateLimitNameLengthTest(String carName) {
        RacingCarController racingCarController = new RacingCarController();
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
        RacingCarController racingCarController = new RacingCarController();
        assertThatThrownBy(() -> racingCarController.extractName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 사용할 수 없습니다.");
    }

}