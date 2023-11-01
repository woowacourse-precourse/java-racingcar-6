package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PlayingServiceTest{
    PlayingService game = new PlayingService();
    final static String ERROR_MSG = "5글자가 넘는 이름은 입력하실 수 없습니다!";

    @Test
    void enterName_예외_테스트() {
        String names = "Int, Char, String";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> game.enterName(names));

        assertThat(e.getMessage()).isEqualTo(ERROR_MSG);
    }
}