package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NumberOfGamesTest {
    private NumberOfGames numberOfGames;
    @BeforeEach
    void setUp() {
        numberOfGames = new NumberOfGames();
    }
    @Test
    void 횟수에_문자_입력() {
        //given(준비): String inputData = "a"
        String inputData = "a";
        //when(실행): validation(inputData)를 실행하면
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            numberOfGames.validation(inputData);
        });
        //then(검증): "숫자를 입력하세요."를 던지는 IllegalArgumentException이 발생해야한다.
        assertEquals("1이상의 정수를 입력하세요.", exception.getMessage());
    }
    @Test
    void 횟수에_음수_입력() {
        //given(준비): String inputData = "-1"
        String inputData = "-1";
        //when(실행): validation(inputData)를 실행하면
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            numberOfGames.validation(inputData);
        });
        //then(검증): "1 이상의 정수를 입력하세요."를 던지는 IllegalArgumentException이 발생해야한다.
        assertEquals("게임 진행 횟수는 1회 이상 이어야 합니다.", exception.getMessage());
    }
    @Test
    void 횟수에_실수_입력() {
        //given(준비): String inputData = "10.4"
        String inputData = "10.4";
        //when(실행): validation(inputData)를 실행하면
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            numberOfGames.validation(inputData);
        });
        //then(검증): "1 이상의 정수를 입력하세요."를 던지는 IllegalArgumentException이 발생해야한다.
        assertEquals("1이상의 정수를 입력하세요.", exception.getMessage());
    }
}