package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionTest {

    @ParameterizedTest
    @EmptySource
    void 자동차등록_잘못된값예외처리_입력없음(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName(inputValue);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차 이름", " 자동차이름", "자동차이름 ", " "})
    void 자동차등록_잘못된값예외처리_공백포함(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName(inputValue);
                });
    }

    @Test
    void 자동차등록_잘못된값예외처리_5자초과() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName("자동차이름테스트");
                });
    }

    @Test
    void 자동차등록_잘못된값예외처리_중복이름() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkCarName("자동차이름,자동차이름");
                });
    }

    @ParameterizedTest
    @EmptySource
    void 경주횟수등록_잘못된값예외처리_입력없음(String inputValue) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount(inputValue);
                });
    }

    @Test
    void 경주횟수등록_잘못된값예외처리_문자입력() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount("다섯번");
                });
    }

    @Test
    void 경주횟수등록_잘못된값예외처리_0입력() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount("0");
                });
    }
}