package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.service.RacingService;

import java.util.List;

public class ValidatorTest {

    RacingService racingService = new RacingService();
    RacingController racingController = new RacingController();
    @Test
    void 자동차_이름에_공백만_있는_경우() {
        String input = "pobi,woni, ";

        assertThatThrownBy(() ->
                racingService.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
