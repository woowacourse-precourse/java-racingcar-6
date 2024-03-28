package racingcar.domain.reception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


class ReceptionDeskTest {

    @ParameterizedTest
    @DisplayName("split 사용 시 쉼표만 입력되는 경우 테스트")
    @ValueSource(strings = {",", ",,", ",,,", ",,,,"})
    void split_쉼표만_입력된_경우(String val) {
        String[] result = val.split(",");

        assertThat(result).isEmpty();
    }

//    @ParameterizedTest
//    @DisplayName("split 사용 시 쉼표 전후에 값이 없는 경우 테스트")
//    @CsvSource(value = {"123,,", ",123,", ",,123"}, delimiterString = ":")
//    void split_쉼표_전후에_값이_없는_경우(String val) {
//        String[] result = val.split(",");
//
//        assertThat(result).isEmpty();
//    }

    @DisplayName("registering 메서드 사용 시 해쉬맵 반환")
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