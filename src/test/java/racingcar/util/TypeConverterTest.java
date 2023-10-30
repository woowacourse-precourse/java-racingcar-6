package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TypeConverterTest {

    @DisplayName("전진 횟수 입력 에러 발생 테스트")
    @Test
    void round() {
        assertThatThrownBy(() -> TypeConverter.toInt("A")).isInstanceOf(IllegalArgumentException.class);
    }
}
