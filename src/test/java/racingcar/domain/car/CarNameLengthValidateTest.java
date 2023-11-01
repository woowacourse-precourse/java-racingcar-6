package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameLengthValidateTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1", "22", "333", "4444", "55555"
    })
    @DisplayName("차 이름 생성 시 길이 기준 이내의 문자열을 허용한다.")
    void carNameLengthValidateSuccessTest(String name) {
        // then
        Assertions.assertDoesNotThrow(() -> {
            new CarName(name);
        });
    }

    @Test
    @DisplayName("차 이름 생성 시 길이 기준 미만/초과의 문자열을 불허한다.")
    void carNameLengthValidateFailTest_Below() {
        // given
        String name_belowLength = "";
        String name_overLength = "666666";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CarName(name_belowLength);
            new CarName(name_overLength);
        });
    }

}
