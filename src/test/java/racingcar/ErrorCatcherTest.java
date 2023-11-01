package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ErrorCatcherTest {

    @Test
    void 이름_예외처리_확인() {
        //given
        List<String> longName = new ArrayList<String>(Arrays.asList("kwonminhyeok"));

        //when then
        assertThatThrownBy(() -> {ErrorCatcher.carNamingCheck(longName);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수_예외처리_확인() {
        //given
        int zeroGameCount = 0;

        //when then
        assertThatThrownBy(() -> {ErrorCatcher.gameCountCheck(zeroGameCount);}).isInstanceOf(IllegalArgumentException.class);
    }
}
