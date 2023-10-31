package racingcar.model.manager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarMoveManagerTest {
    @ParameterizedTest
    @DisplayName("값에 따른 전진 판단 검사")
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6: true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진_판단_검사(String input, String expected) {
        assertThat(new CarMoveManager().isMove(Integer.parseInt(input)))
                .isEqualTo(Boolean.parseBoolean(expected));
    }
}
