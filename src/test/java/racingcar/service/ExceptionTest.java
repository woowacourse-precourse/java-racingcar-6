package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.Exception;

class ExceptionTest {

    @ParameterizedTest
    @EmptySource
    void 자동차등록_입력없음_예외처리(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName(inputValue);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차 이름", " 자동차이름", "자동차이름 ", " "})
    void 자동차등록_공백포함_예외처리(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName(inputValue);
                });
    }

    @Test
    void 자동차등록_5자초과_예외처리() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName("자동차이름테스트");
                });
    }

    @Test
    void 자동차등록_중복이름_예외처리() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName("자동차이름,자동차이름");
                });
    }

    @ParameterizedTest
    @EmptySource
    void 경주횟수등록_입력없음_예외처리(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount(inputValue);
                });
    }

    @Test
    void 경주횟수등록_문자입력_예외처리() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount("다섯번");
                });
    }
}