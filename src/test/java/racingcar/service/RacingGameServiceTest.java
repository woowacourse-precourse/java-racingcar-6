package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameServiceTest {
    RacingGameService racingGameService = new RacingGameService();

    @BeforeEach
    void cleanUp() {
        racingGameService.init();
    }


}