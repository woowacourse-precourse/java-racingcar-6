package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    @Test
    @DisplayName("구분자로 이름이 나누어지는지 테스트")
    void splitNameTest() {
        List<String> result = Controller.splitName("Steph,curry");
        assertThat(result).contains("Steph", "curry");
    }

    @Test
    @DisplayName("count를 횟수로 읽을 수 있는지 테스트")
    void readCountTest() {
        int result = Controller.readCount("6");
        assertThat(result).isEqualTo(6);
    }


}
