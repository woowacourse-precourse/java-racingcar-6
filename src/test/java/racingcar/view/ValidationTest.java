package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {


    @Test
    @DisplayName("names: 정상 입력이 주어지면 true를 반환한다")
    void names_정상입력() {
        assertTrue(Validation.names(List.of("test1", "test2", "test3")));
    }

    @Test
    @DisplayName("names: list가 비어있으면 false를 반환한다 (빈 문자열이 주어진 경우)")
    void names_빈_문자열() {
        assertFalse(Validation.names(List.of()));
    }

    @Test
    @DisplayName("names: 이름 중 빈 문자열이 있을 경우 false를 반환한다")
    void names_이름_입력_없음() {
        assertFalse(Validation.names(List.of("test1", "test2", "")));
    }

    @Test
    @DisplayName("names: 이름이 공백 문자로만 이루어져 있는 경우 false를 반환한다")
    void names_이름_공백() {
        assertFalse(Validation.names(List.of("test1", "test2", "      ")));
    }

    @Test
    @DisplayName("names: 중복된 이름이 있을 경우 false를 반환한다")
    void names_이름_중복() {
        assertFalse(Validation.names(List.of("test1", "test2", "test1")));
    }

    @Test
    @DisplayName("names: 이름이 5글자를 초과하는 경우 false를 반환한다")
    void names_이름_길이_초과() {
        assertFalse(Validation.names(List.of("test1", "test2", "test33")));
    }
}