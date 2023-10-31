package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("글자수 제한 넘어간 이름으로 인해 Cars 생성 불가 테스트")
    void OverNameMaxLengthTest() {
        var Names = List.of("문제없음", "글자수제한넘어감", "세글자");
        assertThrows(IllegalArgumentException.class, () -> Cars.createCarsUsingCarNames(Names));
    }

    @Test
    @DisplayName("Cars 생성 테스트")
    void createCarsTest() throws Exception {
        var Names = List.of("문제없음", "다섯자까지", "세글자");
        assertDoesNotThrow(() -> Cars.createCarsUsingCarNames(Names));
    }
}