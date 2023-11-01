package racingcar.model;

import org.junit.jupiter.api.Test;

public class GameCountValidatorTest {

    @Test
    void 정상_작동_테스트() {
        String gameCount = "5";

        GameCountValidator.validateGameCount(gameCount);
    }

}
