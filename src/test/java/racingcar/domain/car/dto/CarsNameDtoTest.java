package racingcar.domain.car.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsNameDtoTest {

    @DisplayName("이름 null 입력 시 NPE 확인")
    @Test
    void carsNameDtoThrowNPE() {

        assertThatThrownBy(() -> new CarsNameDto(null))
                .isInstanceOf(NullPointerException.class);
    }

}
