package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CarNameValidatorTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            '   ', 자동차 이름은 비어있을 수 없습니다
            ' a', 자동차 이름 양 옆에 공백이 올 수 없습니다
            'a ', 자동차 이름 양 옆에 공백이 올 수 없습니다
            123456, 자동차 이름은 5자 이하여야 합니다
            """)
    void 검증이_실패하면_예외가_발생한다(String name, String message) {
        CarNameValidator carNameValidator = new CarNameValidator();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.accept(name))
                .withMessage(message);
    }
}
