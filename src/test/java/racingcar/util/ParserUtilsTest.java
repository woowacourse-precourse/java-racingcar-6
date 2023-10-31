package racingcar.util;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserUtilsTest {

    @Test
    @DisplayName("Parsing user input, separating it by commas")
    void 사용자의_자동차_이름_입력을_파싱해서_List_Collection_으로_반환() {
        String carNames1 = "ham,seok,myung";
        List<String> carNameArray1 = ParserUtils.namesParser(carNames1);
        List<String> expectedValue1 = Arrays.asList("ham", "seok", "myung");
        Assertions.assertThat(carNameArray1).isEqualTo(expectedValue1);

        String carNames2 = "ham";
        List<String> carNameArray2 = ParserUtils.namesParser(carNames2);
        List<String> expectedValue2 = Arrays.asList("ham");
        Assertions.assertThat(carNameArray2).isEqualTo(expectedValue2);
    }
}