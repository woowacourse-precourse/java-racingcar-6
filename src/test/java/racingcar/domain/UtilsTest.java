package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

    @Test
    void translateArrayToList_배열을_리스트로_변환() {
        String[] array = {"pobi", "woni", "jun"};
        List<String> list = new ArrayList<>();

        List<String> result = Utils.translateArrayToList(array, list);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void checkNameOverLengthException_배열의_사이즈가_5이하() {
        String[] isOkayName = {"pobi", "woni", "jun"};
        String[] noneOkayName = {"pobiwoni", "wonijun"};

        boolean isOkayResult = Utils.checkNameOverLengthException(isOkayName);
        boolean noneOkayResult = Utils.checkNameOverLengthException(noneOkayName);

        assertThat(isOkayResult).isFalse();
        assertThat(noneOkayResult).isTrue();
    }

    @Test
    void checkStringToIntException_숫자를_입력() {
        String intResult = "55";
        String stringResult = "aa";

        boolean isOkayResult = Utils.checkStringToIntException(intResult);
        boolean noneOkayResult = Utils.checkStringToIntException(stringResult);

        assertThat(isOkayResult).isFalse();
        assertThat(noneOkayResult).isTrue();
    }

    @Test
    void makeRandomInt_0부터_9사이의_숫자의_랜덤값() {
        int randomInt = Utils.makeRandomInt();

        assertThat(randomInt).isInstanceOf(Integer.class)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
