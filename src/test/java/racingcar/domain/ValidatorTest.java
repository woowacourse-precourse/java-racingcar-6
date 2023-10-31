package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Validator;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 유효한_자동차_이름_입력(String input) {
        Assertions.assertDoesNotThrow(() -> validator.validateInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" car1, car2,car3,car4"})
    void 공백이_포함된_이름_입력_공백_제거(String input) {
        Assertions.assertDoesNotThrow(() -> validator.validateInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈_문자열_입력_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"mickey,minnie,donald,daisy"})
    void 자동차_이름_다섯_글자_이상(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateNameLength(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1,test1,test2"})
    void 중복된_이름(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateUniqueName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void 유효한_이동_횟수_입력(String input) {
        Assertions.assertDoesNotThrow(() -> validator.validateMoveCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3"})
    void 너무_적은_이동_횟수_입력_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateNameCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"300"})
    void 너무_큰_이동_횟수_입력_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoveCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄱㄴㄷ"})
    void 숫자가_아닌_이동_횟수_입력_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoveCount(input));
    }

}