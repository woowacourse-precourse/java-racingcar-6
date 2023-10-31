package racingcar.validatorTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputCarNameValidator;

public class InputCarNameValidatorTest {
    private InputCarNameValidator inputCarNameValidator;

    @BeforeEach()
    public void initInputCarValidator() {
        inputCarNameValidator = new InputCarNameValidator();
    }

    @DisplayName("자동차 이름을 제대로 입력한경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "po,won,jun,kane", "pobi,won,jun,kane,alex",})
    void 올바른_자동차_이름_테스트(String carsName) {
        assertThatCode(() -> inputCarNameValidator.validateCarName(carsName)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 6자이상인 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobipobi,woni,jun", "pobibi,woniswon,junn", "pobisss,wonssi,junssss",})
    void 자동차_이름의_길이가_5보다_길때_테스트(String carsName) {
        assertThat(inputCarNameValidator.isCorrectCarLength(carsName)).isFalse();
    }

    @DisplayName("자동차 이름사이에 공백이 있는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ,pobi,woni,jun", "po bi,wo n i,jun", "p  obi,wo  ni,j  un",})
    void 자동차_이름사이에_공백이_있는경우_테스트(String carsName) {
        assertThat(inputCarNameValidator.isContainBlank(carsName)).isTrue();
    }

    @DisplayName("자동차 이름을 중복으로 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi,jun", "pobi,woni,woni", "pobi,pobi,pobi"})
    void 자동차_이름이_중복된경우_테스트(String carsName) {
        assertThat(inputCarNameValidator.isOverlapCarName(carsName)).isTrue();
    }

    @DisplayName("자동차 이름이 쉼표로 시작한경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", ",,pobi,woni,woni"})
    void 자동차_이름이_쉼표로시작한경우_테스트(String carsName) {
        assertThat(inputCarNameValidator.isStartComma(carsName)).isTrue();
    }

    @DisplayName("자동차이름이 공백인경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni,jun", "pobi,,,,,,,woni,woni"})
    void 자동차_이름이_공백인경우_테스트(String carsName) {
        assertThat(inputCarNameValidator.isBlankCarName(carsName)).isTrue();
    }

}
