package service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void CheckNameCount_자동차_개수가_하나일_경우_예외_발생() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");

        assertThatThrownBy(() -> { Validation.CheckNameCount(carNames); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkDuplicate_자동차_이름이_중복될_경우_예외_발생() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car1");

        assertThatThrownBy(() -> { Validation.CheckDuplicate(carNames); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkLength_자동차_이름이_빈_문자열일_경우_예외_발생() {
        String carName = null;

        assertThatThrownBy(() -> { Validation.CheckLength(carName); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkLength_자동차_이름이_지정_길이보다_긴_문자열일_경우_예외_발생() {
        String carName = "morethan5";

        assertThatThrownBy(() -> { Validation.CheckLength(carName); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkSpace_공백으로_이루어진_자동차_이름일_경우_예외_발생() {
        String carName = "   ";

        assertThatThrownBy(() -> { Validation.CheckSpace(carName); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkComma_자동차_이름에_콤마가_들어갈_경우_예외_발생() {
        String carName = "1,2";

        assertThatThrownBy(() -> { Validation.CheckComma(carName); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkTimes_0으로_시작하는_숫자일_경우_예외_발생() {
        String time = "01";

        assertThatThrownBy(() -> { Validation.CheckTimes(time); })
                .isInstanceOf(Exception.class);
    }

    @Test
    void checkTimes_숫자가_아닐_경우_예외_발생() {
        String time = "car";

        assertThatThrownBy(() -> { Validation.CheckTimes(time); })
                .isInstanceOf(Exception.class);
    }
}