package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class TransformUtilTest {

    @ParameterizedTest
    @DisplayName("int 값이 주어지면 int 값 개수만큼 대시로 변환")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void 대시_변환(Integer number) {
        // when
        String dashes = TransformUtil.dashes(number);

        // then
        Assertions.assertThat(number).isEqualTo(dashes.length());
    }
    
    @Test
    @DisplayName("쉼표를 기준으로 문자열에서 리스트로 변환")
    public void 쉼표를_기준으로_문자열에서_리스트로_변환() {
        // given
        String data = "car, cat, dog, pubg";
        List<String> expectedValues = Arrays.asList("car", "cat", "dog", "pubg");
        
        // when
        List<String> commasToList
                = TransformUtil.commasToList(data);

        // then
        Assertions.assertThat(commasToList).containsExactlyElementsOf(expectedValues);
    }

    @Test
    @DisplayName("쉼표를 기준으로 문자열에서 리스트로 변환")
    public void 쉼표를_기준으로_리스트에서_문자열로_변환() {
        // given
        List<String> expectedValues = Arrays.asList("car", "cat", "dog", "pubg");
        String data = "car, cat, dog, pubg";

        // when
        String transformToString = TransformUtil.commasToString(expectedValues);

        // then
        Assertions.assertThat(data).isEqualTo(transformToString);
    }

}
