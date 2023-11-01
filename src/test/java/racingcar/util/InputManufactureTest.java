package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputManufactureTest {
    InputManufacture inputManufacture = new InputManufacture();

    @Test
    void 쉼표로_구분된_문자열_입력값을_리스트로_반환() {
        String data = "star,moon,stardust";
        List<String> result = new ArrayList<>(Arrays.asList(data.split(",")));
        assertThat(inputManufacture.makeNameList(data)).isEqualTo(result);
    }

    @Test
    void 문자로_된_숫자를_Integer로_변환() {
        String number = "8";
        int result = 8;
        assertThat(inputManufacture.changeIntegerNumber(number)).isEqualTo(result);
    }
}
