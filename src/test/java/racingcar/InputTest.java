package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import racingcar.Service.RaceService;
import racingcar.controller.RaceController;

public class InputTest {
    @DisplayName("시도 회수를 요청했을 때 숫자를 입력했을 때.")
    @Test
    void requestAttemptTrue(){
        //given
        String input="4";
        //then
        assertThat(Integer.parseInt(input)).isEqualTo(4);
    }
    @DisplayName("시도 회수를 요청했을 때 문자를 입력했을 때")
    @Test
    void requestAttemptFalse(){
        //givne
        String input="a1";
        //then
        assertThrows(IllegalArgumentException.class,()->{Integer.parseInt(input);});
    }


}
