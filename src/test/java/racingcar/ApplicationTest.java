package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.RaceValidation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private RaceValidation raceValidation = new RaceValidation();
    @Test
    @DisplayName("자동차 이름 입력에 쉼포가 없으면 예외 발생")
    void validateSeparator() {
        String includeComma = "자동차1,자동차2";
        String unIncludeComma = "자동차1자동차2";
        assertThatNoException().isThrownBy(() -> raceValidation.validationSeparator(includeComma));
        assertThatThrownBy(() -> raceValidation.validationSeparator(unIncludeComma)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 이름 5글자 넘길 시 예외 발생")
    void validateNameLength() {
        String carName1 = "마이바흐";
        String carName2 = "롤스로이스 고스트";
        assertThatNoException().isThrownBy(() -> raceValidation.validationNameLength(carName1));
        assertThatThrownBy(() -> raceValidation.validationNameLength(carName2)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test

    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
