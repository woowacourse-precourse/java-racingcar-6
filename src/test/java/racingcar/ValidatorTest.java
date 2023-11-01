package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    @Test
    void 자동차의_이름이_올바른_경우() {
        // given
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("woni");
        carNameList.add("jun");

        // when

        //then
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }

    @Test
    void 자동차의_이름이_없는_경우() {
        // given
        List<String> carNameList = new ArrayList<>();

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateCarName(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 없습니다.");
    }

    @Test
    void 자동차의_이름이_5글자_초과인_경우() {
        // given
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pooobi");
        carNameList.add("woni");
        carNameList.add("jun");

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateCarName(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차의_이름이_중복된_경우() {
        // given
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("woni");
        carNameList.add("pobi");

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateCarName(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 이동을_시도할_횟수가_올바른_경우() {
        // given
        String roundTime = "5";

        // when

        //then
        assertThat(roundTime).isEqualTo("5");
    }

    @Test
    void 이동을_시도할_횟수가_없는_경우() {
        // given
        String roundTime = "";

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateRoundTimeNumber(roundTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 없습니다.");
    }

    @Test
    void 이동을_시도할_횟수가_숫자가_아닌_경우() {
        // given
        String roundTime = "car";

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateRoundTimeNumber(roundTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    void 이동을_시도할_횟수가_0_미만인_경우() {
        // given
        String roundTime = "0";

        // when

        //then
        assertThatThrownBy(() -> Validator.isValidateRoundTimeNumber(roundTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동을 시도할 횟수는 자연수이어야 합니다.");
    }
}
