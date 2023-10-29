package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionTest {

    @BeforeAll
    static void testStart() {
        System.out.println("테스트를 시작합니다.");
    }

    @BeforeEach
    void unitTestStart() {
        System.out.print("- 테스트 메소드 실행 / ");
    }

    @AfterEach
    void unitTestEnd() {
        System.out.println("종료");
    }

    @AfterAll
    static void testEnd() {
        System.out.println("테스트를 종료합니다.");
    }

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

    @Test
    void 경주횟수등록_0입력_예외처리() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Exception.checkRaceCount("0");
                });
    }
}