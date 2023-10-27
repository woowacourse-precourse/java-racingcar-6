package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilsTest {
        @Test
        void 시도할_회수는_자연수만_가능합니다() {
            assertEquals(Utils.isNaturalNumber("-1"), false);
        }
}