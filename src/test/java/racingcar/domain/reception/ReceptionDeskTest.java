package racingcar.domain.reception;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


class ReceptionDeskTest {

    @Test
    void 이름등록() {
        final HashMap<String, Integer> lineUp = ReceptionDesk.registering(new String[]{"hi", "my", "name", "is", "hello", "world"});
        assertThat(lineUp)
                .isNotEmpty()
                .hasSize(6)
                .containsKeys(new String[]{"hi", "my", "name", "is", "hello", "world"})
                .containsValues(0);
    }

}