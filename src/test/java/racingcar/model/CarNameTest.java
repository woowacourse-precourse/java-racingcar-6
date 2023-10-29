package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    public void 입력받은_이름의_길이가_5이상이면_오류() {
        String input = "123456";

        assertThrows(IllegalArgumentException.class, () -> {
            new CarName(input);
        });
    }
}