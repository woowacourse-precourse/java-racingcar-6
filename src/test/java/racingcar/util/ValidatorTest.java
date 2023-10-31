package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingService;

import java.util.List;

public class ValidatorTest {

    RacingService racingService = new RacingService();
    @Test
    void 자동차_이름_길이가_0인_경우() {
        String input = "pobi,woni, ";

        assertThatThrownBy(() ->
                racingService.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
