package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_이름이_있을_때_생성시_예외처리() {
        // given
        List<String> names = List.of("duplicated", "duplicated");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Cars.from(names);
        });
    }
}
