package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3\n"})
    void 유효한_자동차_이름_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertDoesNotThrow(() -> user.getCarNames());
    }

    @ParameterizedTest
    @ValueSource(strings = {" car1, car2,car3,car4\n"})
    void 공백이_포함된_이름_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertDoesNotThrow(() -> user.getCarNames());
    }

    @ParameterizedTest
    @ValueSource(strings = {" \n"})
    void 빈_문자열_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getCarNames());
    }

    @ParameterizedTest
    @ValueSource(strings = {"mickey,minnie,donald,daisy\n"})
    void 자동차_이름_다섯_글자_이상(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getCarNames());
    }

    @ParameterizedTest
    @ValueSource(strings = {"mickey,mikey,minnie\n"})
    void 중복된_이름(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getCarNames());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5\n"})
    void 유효한_이동_횟수_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertDoesNotThrow(() -> user.getRaceCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3\n"})
    void 너무_적은_이동_횟수_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getRaceCount());
    }
    @ParameterizedTest
    @ValueSource(strings = {"300\n"})
    void 너무_큰_이동_횟수_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getRaceCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄱㄴㄷ\n"})
    void 숫자가_아닌_이동_횟수_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> user.getRaceCount());
    }

}