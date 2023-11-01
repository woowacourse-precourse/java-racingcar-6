package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi,w o i,jun"})
    @DisplayName("정상 값 테스트")
    void normal_test(String input) {
        List<String> names = List.of(input.split(","));
        assertDoesNotThrow(() -> new Players(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,junjun", "pobi woni junjun"})
    @DisplayName("예외 처리 테스트")
    void exception_test(String input) {
        List<String> names = List.of(input.split(","));
        assertThrows(IllegalArgumentException.class, () -> new Players(names));
    }

}
