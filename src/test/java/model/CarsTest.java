package model;

import static model.ErrorMessage.DUPLICATED_CAR_NAME;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_이름이_있을_때_생성시_예외처리() {
        // given
        List<String> names = List.of("duplicated", "duplicated");

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                Cars.from(names);
            });
            assertEquals(DUPLICATED_CAR_NAME.getMessage(), exception.getMessage());
        });
    }
}
