package racingcar.domain.car.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsNameDtoTest {

    @DisplayName("이름 null 입력 시 IllegalArgumentException 확인")
    @Test
    void carsNameDtoThrowExceptionWhenNamesIsNull() {

        assertThatThrownBy(() -> new CarsNameDto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 하나가 null 입력 시 IllegalArgumentException 확인")
    @Test
    void carsNameDtoThrowExceptionOneOfNameIsNull() {
        String names = "다오,";

        assertThatThrownBy(() -> new CarsNameDto(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표 연속으로 나오는 경우 IllegalArgumentException 확인")
    @Test
    void carsNameDtoThrowExceptionCommasContinuousInput() {
        String names = "다오,,버찌";

        assertThatThrownBy(() -> new CarsNameDto(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
