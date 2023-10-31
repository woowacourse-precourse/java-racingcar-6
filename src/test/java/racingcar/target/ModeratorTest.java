package racingcar.target;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModeratorTest {

    @Test
    @DisplayName("자동차의 이름이 5글자일때 예외처리되는지 확인")
    void validateCarNameTest() {
        //given
        Moderator moderator = new Moderator();
        String carName = "javaji";

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moderator.validateCarName(carName);
        });
    }
}