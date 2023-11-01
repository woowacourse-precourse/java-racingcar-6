package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    void makeTrack_차량에_따른_트랙생성() {
        int input = 5;
        InputCarName inputCarName = new InputCarName();
        List<Integer> result = inputCarName.makeTrack(input);
        assertThat(result).containsExactly(0, 0, 0, 0, 0);
    }
}
